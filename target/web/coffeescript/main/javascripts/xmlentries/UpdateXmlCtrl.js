(function() {
  var UpdateXmlCtrl;

  UpdateXmlCtrl = (function() {
    function UpdateXmlCtrl($log, $location, $routeParams, XmlService) {
      this.$log = $log;
      this.$location = $location;
      this.$routeParams = $routeParams;
      this.XmlService = XmlService;
      this.$log.debug("constructing UpdateXmlEntryController");
      this.entry = {};
      this.findEntry();
    }

    UpdateXmlCtrl.prototype.updateEntry = function() {
      this.$log.debug("updateEntry()");
      return this.XmlService.updateXmlEntry(this.$routeParams.xmlName, this.$routeParams.xmlType, this.entry).then((function(_this) {
        return function(data) {
          _this.$log.debug("Promise returned " + data + " Xml Entry");
          _this.entry = data;
          return _this.$location.path("/");
        };
      })(this), (function(_this) {
        return function(error) {
          return _this.$log.error("Unable to update Xml Entry: " + error);
        };
      })(this));
    };

    UpdateXmlCtrl.prototype.findEntry = function() {
      var xmlName, xmlType;
      xmlName = this.$routeParams.xmlName;
      xmlType = this.$routeParams.xmlType;
      this.$log.debug("findEntry route params: " + xmlName + " " + xmlType);
      return this.XmlService.listXmlEntries().then((function(_this) {
        return function(data) {
          _this.$log.debug("Promise returned " + data.length + " Xml Entries");
          return _this.entry = (data.filter(function(entry) {
            return entry.xmlName === xmlName && entry.xmlType === xmlType;
          }))[0];
        };
      })(this), (function(_this) {
        return function(error) {
          return _this.$log.error("Unable to get Xml Entries: " + error);
        };
      })(this));
    };

    return UpdateXmlCtrl;

  })();

  controllersModule.controller('UpdateXmlCtrl', ['$log', '$location', '$routeParams', 'XmlService', UpdateXmlCtrl]);

}).call(this);

//# sourceMappingURL=UpdateXmlCtrl.js.map
