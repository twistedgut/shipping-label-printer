
class CreateXmlCtrl

    constructor: (@$log, @$location,  @XmlService) ->
        @$log.debug "constructing CreateXmlController"
        @entry = {}

    createXmlEntry: () ->
        @$log.debug "createXmlEntry()"
        @entry.is_active  = true
        @XmlService.createXmlEntry(@entry)
        .then(
            (data) =>
                @$log.debug "Promise returned #{data} Xml Entry"
                @entry = data
                @$location.path("/label/xml/view")
            ,
            (error) =>
                @$log.error "Unable to create Xml Entry: #{error}"
            )

controllersModule.controller('CreateXmlCtrl', ['$log', '$location', 'XmlService', CreateXmlCtrl])