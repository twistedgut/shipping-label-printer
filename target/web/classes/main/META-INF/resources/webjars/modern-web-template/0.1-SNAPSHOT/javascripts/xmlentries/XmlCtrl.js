(function() {
  var XmlCtrl;

  XmlCtrl = (function() {
    function XmlCtrl($log, XmlService) {
      this.$log = $log;
      this.XmlService = XmlService;
      this.$log.debug("constructing XmlController");
      this.entries = [];
      this.getAllEntries();
    }

    XmlCtrl.prototype.getAllEntries = function() {
      this.$log.debug("getAllEntries()");
      return this.XmlService.listXmlEntries().then((function(_this) {
        return function(data) {
          _this.$log.debug("Promise returned " + data.length + " Xml Entries");
          return _this.entries = data;
        };
      })(this), (function(_this) {
        return function(error) {
          return _this.$log.error("Unable to get Xml Entries: " + error);
        };
      })(this));
    };

    return XmlCtrl;

  })();

  controllersModule.controller('XmlCtrl', ['$log', 'XmlService', XmlCtrl]);

}).call(this);

//# sourceMappingURL=XmlCtrl.js.map
