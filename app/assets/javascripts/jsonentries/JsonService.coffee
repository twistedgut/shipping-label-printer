
class JsonService

    @headers = {'Accept': 'application/json', 'Content-Type': 'application/json'}
    @defaultConfig = { headers: @headers }

    constructor: (@$log, @$http, @$q) ->
        @$log.debug "constructing JsonService"

    listJsonEntries: () ->
        @$log.debug "listJsonEntries()"
        deferred = @$q.defer()

        @$http.get("/labels/json")
        .success((data, status, headers) =>
                @$log.info("Successfully listed Json Entries - status #{status}")
                deferred.resolve(data)
            )
        .error((data, status, headers) =>
                @$log.error("Failed to list Json Entries - status #{status}")
                deferred.reject(data)
            )
        deferred.promise

    createJsonEntry: (entry) ->
        @$log.debug "createJsonEntry #{angular.toJson(entry, true)}"
        deferred = @$q.defer()

        @$http.post('/label/json', entry)
        .success((data, status, headers) =>
                @$log.info("Successfully created Json Entry - status #{status}")
                deferred.resolve(data)
            )
        .error((data, status, headers) =>
                @$log.error("Failed to create Json Entry - status #{status}")
                deferred.reject(data)
            )
        deferred.promise

    updateJsonEntry: (jsonName, jsonType, entry) ->
      @$log.debug "updateJsonEntry #{angular.toJson(entry, true)}"
      deferred = @$q.defer()
      @$http.put("/label/json/#{jsonName}/#{jsonType}", entry)
      .success((data, status, headers) =>
              @$log.info("Successfully updated Json Entry - status #{status}")
              deferred.resolve(data)
            )
      .error((data, status, header) =>
              @$log.error("Failed to update Json Entry - status #{status}")
              deferred.reject(data)
            )
      deferred.promise

servicesModule.service('JsonService', ['$log', '$http', '$q', JsonService])