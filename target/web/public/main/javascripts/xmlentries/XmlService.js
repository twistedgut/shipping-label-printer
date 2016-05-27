(function() {
  var XmlService;

  XmlService = (function() {
    XmlService.headers = {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    };

    XmlService.defaultConfig = {
      headers: XmlService.headers
    };

    function XmlService($log, $http, $q) {
      this.$log = $log;
      this.$http = $http;
      this.$q = $q;
      this.$log.debug("constructing XmlService");
    }

    XmlService.prototype.listXmlEntries = function() {
      var deferred;
      this.$log.debug("listXmlEntries()");
      deferred = this.$q.defer();
      this.$http.get("/labels/xml").success((function(_this) {
        return function(data, status, headers) {
          _this.$log.info("Successfully listed Xml Entries - status " + status);
          return deferred.resolve(data);
        };
      })(this)).error((function(_this) {
        return function(data, status, headers) {
          _this.$log.error("Failed to list Xml Entries - status " + status);
          return deferred.reject(data);
        };
      })(this));
      return deferred.promise;
    };

    XmlService.prototype.createXmlEntry = function(entry) {
      var deferred;
      this.$log.debug("createXmlEntry " + (angular.toJson(entry, true)));
      deferred = this.$q.defer();
      this.$http.post('/label/xml', entry).success((function(_this) {
        return function(data, status, headers) {
          _this.$log.info("Successfully created Xml Entry - status " + status);
          return deferred.resolve(data);
        };
      })(this)).error((function(_this) {
        return function(data, status, headers) {
          _this.$log.error("Failed to create Xml Entry - status " + status);
          return deferred.reject(data);
        };
      })(this));
      return deferred.promise;
    };

    XmlService.prototype.updateXmlEntry = function(xmlName, xmlType, entry) {
      var deferred;
      this.$log.debug("updateXmlEntry " + (angular.toJson(entry, true)));
      deferred = this.$q.defer();
      this.$http.put("/label/xml/" + xmlName + "/" + xmlType, entry).success((function(_this) {
        return function(data, status, headers) {
          _this.$log.info("Successfully updated Xml Entry - status " + status);
          return deferred.resolve(data);
        };
      })(this)).error((function(_this) {
        return function(data, status, header) {
          _this.$log.error("Failed to update Xml Entry - status " + status);
          return deferred.reject(data);
        };
      })(this));
      return deferred.promise;
    };

    return XmlService;

  })();

  servicesModule.service('XmlService', ['$log', '$http', '$q', XmlService]);

}).call(this);

//# sourceMappingURL=XmlService.js.map
