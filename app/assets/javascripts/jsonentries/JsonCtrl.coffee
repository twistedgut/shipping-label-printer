
class JsonCtrl

    constructor: (@$log, @JsonService) ->
        @$log.debug "constructing JsonController"
        @entries = []
        @getAllEntries()

    getAllEntries: () ->
        @$log.debug "getAllEntries()"

        @JsonService.listJsonEntries()
        .then(
            (data) =>
                @$log.debug "Promise returned #{data.length} Json Entries"
                @entries = data
            ,
            (error) =>
                @$log.error "Unable to get Json Entries: #{error}"
            )

controllersModule.controller('JsonCtrl', ['$log', 'JsonService', JsonCtrl])