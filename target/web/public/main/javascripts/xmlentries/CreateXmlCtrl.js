(function() {
  var CreateXmlCtrl;

  CreateXmlCtrl = (function() {
    function CreateXmlCtrl($log, $location, XmlService) {
      this.$log = $log;
      this.$location = $location;
      this.XmlService = XmlService;
      this.$log.debug("constructing CreateXmlController");
      this.entry = {};
    }

    CreateXmlCtrl.prototype.createXmlEntry = function() {
      this.$log.debug("createXmlEntry()");
      return this.XmlService.createXmlEntry(this.entry).then((function(_this) {
        return function(data) {
          _this.$log.debug("Promise returned " + data + " Xml Entry");
          _this.entry = data;
          return _this.$location.path("/");
        };
      })(this), (function(_this) {
        return function(error) {
          return _this.$log.error("Unable to create Xml Entry: " + error);
        };
      })(this));
    };

    return CreateXmlCtrl;

  })();

  controllersModule.controller('CreateXmlCtrl', ['$log', '$location', 'XmlService', CreateXmlCtrl]);

}).call(this);

//# sourceMappingURL=CreateXmlCtrl.js.map
