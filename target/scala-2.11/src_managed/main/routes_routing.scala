// @SOURCE:/Users/j.maslen/Software/scala/modern-web-template/conf/routes
// @HASH:d4c9a1c971a7ab26f99990ea9921a4f60ed2c4df
// @DATE:Fri May 27 15:01:43 BST 2016


import scala.language.reflectiveCalls
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:8
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Single endpoint for serving AngularJS""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Application_randomUUID1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("randomUUID"))))
private[this] lazy val controllers_Application_randomUUID1_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).randomUUID,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "randomUUID", Nil,"GET", """""", Routes.prefix + """randomUUID"""))
        

// @LINE:12
private[this] lazy val controllers_Users_findUsers2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
private[this] lazy val controllers_Users_findUsers2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Users]).findUsers,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "findUsers", Nil,"GET", """ User management API""", Routes.prefix + """users"""))
        

// @LINE:13
private[this] lazy val controllers_Users_createUser3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_Users_createUser3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Users]).createUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "createUser", Nil,"POST", """""", Routes.prefix + """user"""))
        

// @LINE:14
private[this] lazy val controllers_Users_updateUser4_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("firstName", """[^/]+""",true),StaticPart("/"),DynamicPart("lastName", """[^/]+""",true))))
private[this] lazy val controllers_Users_updateUser4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Users]).updateUser(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "updateUser", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """user/$firstName<[^/]+>/$lastName<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_LabelXml_findXmlEntries5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("labels/xml"))))
private[this] lazy val controllers_LabelXml_findXmlEntries5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LabelXml]).findXmlEntries,
HandlerDef(this.getClass.getClassLoader, "", "controllers.LabelXml", "findXmlEntries", Nil,"GET", """ DHL XML management API""", Routes.prefix + """labels/xml"""))
        

// @LINE:18
private[this] lazy val controllers_LabelXml_createXmlEntry6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("label/xml"))))
private[this] lazy val controllers_LabelXml_createXmlEntry6_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LabelXml]).createXmlEntry,
HandlerDef(this.getClass.getClassLoader, "", "controllers.LabelXml", "createXmlEntry", Nil,"POST", """""", Routes.prefix + """label/xml"""))
        

// @LINE:19
private[this] lazy val controllers_LabelXml_updateXmlEntry7_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("label/xml/"),DynamicPart("xmlName", """[^/]+""",true),StaticPart("/"),DynamicPart("xmlType", """[^/]+""",true))))
private[this] lazy val controllers_LabelXml_updateXmlEntry7_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LabelXml]).updateXmlEntry(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LabelXml", "updateXmlEntry", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """label/xml/$xmlName<[^/]+>/$xmlType<[^/]+>"""))
        

// @LINE:22
private[this] lazy val controllers_Assets_versioned8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[Asset]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""@controllers.Application@.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """randomUUID""","""@controllers.Application@.randomUUID"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""@controllers.Users@.findUsers"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.Users@.createUser"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$firstName<[^/]+>/$lastName<[^/]+>""","""@controllers.Users@.updateUser(firstName:String, lastName:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """labels/xml""","""@controllers.LabelXml@.findXmlEntries"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """label/xml""","""@controllers.LabelXml@.createXmlEntry"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """label/xml/$xmlName<[^/]+>/$xmlType<[^/]+>""","""@controllers.LabelXml@.updateXmlEntry(xmlName:String, xmlType:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:Asset)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:8
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index)
   }
}
        

// @LINE:9
case controllers_Application_randomUUID1_route(params) => {
   call { 
        controllers_Application_randomUUID1_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).randomUUID)
   }
}
        

// @LINE:12
case controllers_Users_findUsers2_route(params) => {
   call { 
        controllers_Users_findUsers2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Users]).findUsers)
   }
}
        

// @LINE:13
case controllers_Users_createUser3_route(params) => {
   call { 
        controllers_Users_createUser3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Users]).createUser)
   }
}
        

// @LINE:14
case controllers_Users_updateUser4_route(params) => {
   call(params.fromPath[String]("firstName", None), params.fromPath[String]("lastName", None)) { (firstName, lastName) =>
        controllers_Users_updateUser4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Users]).updateUser(firstName, lastName))
   }
}
        

// @LINE:17
case controllers_LabelXml_findXmlEntries5_route(params) => {
   call { 
        controllers_LabelXml_findXmlEntries5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LabelXml]).findXmlEntries)
   }
}
        

// @LINE:18
case controllers_LabelXml_createXmlEntry6_route(params) => {
   call { 
        controllers_LabelXml_createXmlEntry6_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LabelXml]).createXmlEntry)
   }
}
        

// @LINE:19
case controllers_LabelXml_updateXmlEntry7_route(params) => {
   call(params.fromPath[String]("xmlName", None), params.fromPath[String]("xmlType", None)) { (xmlName, xmlType) =>
        controllers_LabelXml_updateXmlEntry7_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LabelXml]).updateXmlEntry(xmlName, xmlType))
   }
}
        

// @LINE:22
case controllers_Assets_versioned8_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        
}

}
     