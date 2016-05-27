(function() {
  var app, dependencies;

  dependencies = ['ngRoute', 'ui.bootstrap', 'myApp.filters', 'myApp.services', 'myApp.controllers', 'myApp.directives', 'myApp.common', 'myApp.routeConfig'];

  app = angular.module('myApp', dependencies);

  angular.module('myApp.routeConfig', ['ngRoute']).config([
    '$routeProvider', function($routeProvider) {
      return $routeProvider.when('/', {
        templateUrl: '/assets/partials/view.html'
      }).when('/label/xml/view', {
        templateUrl: '/assets/partials/view.html'
      }).when('/label/xml/create', {
        templateUrl: '/assets/partials/create.html'
      }).when('/label/xml/update/:xmlName/:xmlType', {
        templateUrl: '/assets/partials/update.html'
      }).otherwise({
        redirectTo: '/'
      });
    }
  ]).config([
    '$locationProvider', function($locationProvider) {
      return $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
      });
    }
  ]);

  this.commonModule = angular.module('myApp.common', []);

  this.controllersModule = angular.module('myApp.controllers', []);

  this.servicesModule = angular.module('myApp.services', []);

  this.modelsModule = angular.module('myApp.models', []);

  this.directivesModule = angular.module('myApp.directives', []);

  this.filtersModule = angular.module('myApp.filters', []);

}).call(this);

//# sourceMappingURL=app.js.map
