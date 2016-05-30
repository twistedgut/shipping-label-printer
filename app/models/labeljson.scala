package models

case class JsonEntry(
                     jsonName   :String,
                     jsonType   :String,
                     jsonText   :String,
                     is_active  :Boolean)

object JsonFormats {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and XmlEntry thanks to Json Macros
  implicit val jsonEntryFormat = Json.format[JsonEntry]
}