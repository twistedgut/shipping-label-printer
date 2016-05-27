package models

case class XmlEntry(
                 xmlName: String,
                 xmlType: String)
//                 xmlText: String)

object EntryJsonFormats {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and XmlEntry thanks to Json Macros
  implicit val xmlEntryFormat = Json.format[XmlEntry]
}