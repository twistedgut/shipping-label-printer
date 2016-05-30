
class CreateJsonCtrl

    constructor: (@$log, @$location,  @JsonService) ->
        @$log.debug "constructing CreateJsonController"
        @entry = {}

    createJsonEntry: () ->
        @$log.debug "createJsonEntry()"
        @entry.is_active  = true
        @JsonService.createJsonEntry(@entry)
        .then(
            (data) =>
                @$log.debug "Promise returned #{data} Json Entry"
                @entry = data
                @$location.path("/")
            ,
            (error) =>
                @$log.error "Unable to create Json Entry: #{error}"
            )

controllersModule.controller('CreateJsonCtrl', ['$log', '$location', 'JsonService', CreateJson                      Ctrl])