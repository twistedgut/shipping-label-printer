
class XmlCtrl

    constructor: (@$log, @XmlService) ->
        @$log.debug "constructing XmlController"
        @entries = []
        @getAllEntries()

    getAllEntries: () ->
        @$log.debug "getAllEntries()"

        @XmlService.listXmlEntries()
        .then(
            (data) =>
                @$log.debug "Promise returned #{data.length} Xml Entries"
                @entries = data
            ,
            (error) =>
                @$log.error "Unable to get Xml Entries: #{error}"
            )

controllersModule.controller('XmlCtrl', ['$log', 'XmlService', XmlCtrl])