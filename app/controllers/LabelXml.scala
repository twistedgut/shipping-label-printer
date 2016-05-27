package controllers

import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import scala.concurrent.Future
import reactivemongo.api.Cursor
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import org.slf4j.{LoggerFactory, Logger}
import javax.inject.Singleton
import play.api.mvc._
import play.api.libs.json._

/**
  * The LabelXml controllers encapsulates the Rest endpoints and the interaction with the MongoDB, via ReactiveMongo
  * play plugin. This provides a non-blocking driver for mongoDB as well as some useful additions for handling JSon.
  * @see https://github.com/ReactiveMongo/Play-ReactiveMongo
  */
@Singleton
class LabelXml extends Controller with MongoController {

  private final val logger: Logger = LoggerFactory.getLogger(classOf[LabelXml])

  /*
   * Get a JSONCollection (a Collection implementation that is designed to work
   * with JsObject, Reads and Writes.)
   * Note that the `collection` is not a `val`, but a `def`. We do _not_ store
   * the collection reference to avoid potential problems in development with
   * Play hot-reloading.
   */
  def collection: JSONCollection = db.collection[JSONCollection]("labelxml")

  // ------------------------------------------ //
  // Using case classes + Json Writes and Reads //
  // ------------------------------------------ //

  import models._
  import models.EntryJsonFormats._

  def createXmlEntry = Action.async(parse.json) {
    request =>
      /*
       * request.body is a JsValue.
       * There is an implicit Writes that turns this JsValue as a JsObject,
       * so you can call insert() with this JsValue.
       * (insert() takes a JsObject as parameter, or anything that can be
       * turned into a JsObject using a Writes.)
       */
      request.body.validate[XmlEntry].map {
        xmlentry =>
          // `xmlentry` is an instance of the case class `models.XmlEntry`
          collection.insert(xmlentry).map {
            lastError =>
              logger.debug(s"Successfully inserted with LastError: $lastError")
              Created(s"XML Entry Created")
          }
      }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def updateXmlEntry(xmlName: String, xmlType: String) = Action.async(parse.json) {
    request =>
      request.body.validate[XmlEntry].map {
        xmlentry =>
          // find our xml entry by xml name and xml type
          val xmlSelector = Json.obj("xmlName" -> xmlName, "xmlType" -> xmlType)
          collection.update(xmlSelector, xmlentry).map {
            lastError =>
              logger.debug(s"Successfully updated with LastError: $lastError")
              Created(s"XML Entry Updated")
          }
      }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def deleteXmlEntry(xmlName: String, xmlType: String) = Action.async(parse.json) {
    request =>
      request.body.validate[XmlEntry].map {
        xmlentry =>
          collection.remove(xmlentry).map {
            lastError =>
              logger.debug(s"Successfully deleted with LastError: $lastError")
              Created(s"XML Entry Deleted")
          }
      }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def findXmlEntries = Action.async {
    // let's do our query
    val cursor: Cursor[XmlEntry] = collection.find(Json.obj()).cursor[XmlEntry]

    // gather all the JsObjects in a list
    val futureXmlEntriesList: Future[List[XmlEntry]] = cursor.collect[List]()

    // transform the list into a JsArray
    val futureEntriesJsonArray: Future[JsArray] = futureXmlEntriesList.map { entries =>
      Json.arr(entries)
    }
    // everything's ok! Let's reply with the array
    futureEntriesJsonArray.map {
      entries =>
        Ok(entries(0))
    }
  }

}