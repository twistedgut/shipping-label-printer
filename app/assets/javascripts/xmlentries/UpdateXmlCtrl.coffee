class UpdateXmlCtrl

  constructor: (@$log, @$location, @$routeParams, @XmlService) ->
      @$log.debug "constructing UpdateXmlEntryController"
      @entry = {}
      @findEntry()

  updateEntry: () ->
      @$log.debug "updateEntry()"
      @XmlService.updateXmlEntry(@$routeParams.xmlName, @$routeParams.xmlType, @entry)
      .then(
          (data) =>
            @$log.debug "Promise returned #{data} Xml Entry"
            @entry = data
            @$location.path("/label/xml/view")
        ,
        (error) =>
            @$log.error "Unable to update Xml Entry: #{error}"
      )

  findEntry: () ->
      # route params must be same name as provided in routing url in app.coffee
      xmlName = @$routeParams.xmlName
      xmlType = @$routeParams.xmlType
      @$log.debug "findEntry route params: #{xmlName} #{xmlType}"

      @XmlService.listXmlEntries()
      .then(
        (data) =>
          @$log.debug "Promise returned #{data.length} Xml Entries"

          # find an entry with the name of xmlName and type of xmlType
          # as filter returns an array, get the first object in it, and return it
          @entry = (data.filter (entry) -> entry.xmlName is xmlName and entry.xmlType is xmlType)[0]
      ,
        (error) =>
          @$log.error "Unable to get Xml Entries: #{error}"
      )

controllersModule.controller('UpdateXmlCtrl', ['$log', '$location', '$routeParams', 'XmlService', UpdateXmlCtrl])