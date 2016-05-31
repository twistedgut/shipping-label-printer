class UpdateJsonCtrl

  constructor: (@$log, @$location, @$routeParams, @JsonService) ->
      @$log.debug "constructing UpdateJsonEntryController"
      @entry = {}
      @findEntry()

  updateEntry: () ->
      @$log.debug "updateEntry()"
      @JsonService.updateJsonEntry(@$routeParams.jsonName, @$routeParams.jsonType, @entry)
      .then(
          (data) =>
            @$log.debug "Promise returned #{data} Json Entry"
            @entry = data
            @$location.path("/label/json/view")
        ,
        (error) =>
            @$log.error "Unable to update Json Entry: #{error}"
      )

  findEntry: () ->
      # route params must be same name as provided in routing url in app.coffee
      jsonName = @$routeParams.jsonName
      jsonType = @$routeParams.jsonType
      @$log.debug "findEntry route params: #{jsonName} #{jsonType}"

      @JsonService.listJsonEntries()
      .then(
        (data) =>
          @$log.debug "Promise returned #{data.length} Json Entries"

          # find an entry with the name of jsonName and type of jsonType
          # as filter returns an array, get the first object in it, and return it
          @entry = (data.filter (entry) -> entry.jsonName is jsonName and entry.jsonType is jsonType)[0]
      ,
        (error) =>
          @$log.error "Unable to get Json Entries: #{error}"
      )

controllersModule.controller('UpdateJsonCtrl', ['$log', '$location', '$routeParams', 'JsonService', UpdateJsonCtrl])