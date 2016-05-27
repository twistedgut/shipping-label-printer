
class XmlService

    @headers = {'Accept': 'application/json', 'Content-Type': 'application/json'}
    @defaultConfig = { headers: @headers }

    constructor: (@$log, @$http, @$q) ->
        @$log.debug "constructing XmlService"

    listXmlEntries: () ->
        @$log.debug "listXmlEntries()"
        deferred = @$q.defer()

        @$http.get("/labels/xml")
        .success((data, status, headers) =>
                @$log.info("Successfully listed Xml Entries - status #{status}")
                deferred.resolve(data)
            )
        .error((data, status, headers) =>
                @$log.error("Failed to list Xml Entries - status #{status}")
                deferred.reject(data)
            )
        deferred.promise

    createXmlEntry: (entry) ->
        @$log.debug "createXmlEntry #{angular.toJson(entry, true)}"
        deferred = @$q.defer()

        @$http.post('/label/xml', entry)
        .success((data, status, headers) =>
                @$log.info("Successfully created Xml Entry - status #{status}")
                deferred.resolve(data)
            )
        .error((data, status, headers) =>
                @$log.error("Failed to create Xml Entry - status #{status}")
                deferred.reject(data)
            )
        deferred.promise

    updateXmlEntry: (xmlName, xmlType, entry) ->
      @$log.debug "updateXmlEntry #{angular.toJson(entry, true)}"
      deferred = @$q.defer()
      @$http.put("/label/xml/#{xmlName}/#{xmlType}", entry)
      .success((data, status, headers) =>
              @$log.info("Successfully updated Xml Entry - status #{status}")
              deferred.resolve(data)
            )
      .error((data, status, header) =>
              @$log.error("Failed to update Xml Entry - status #{status}")
              deferred.reject(data)
            )
      deferred.promise

servicesModule.service('XmlService', ['$log', '$http', '$q', XmlService])