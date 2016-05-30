
dependencies = [
    'ngRoute',
    'ui.bootstrap',
    'myApp.filters',
    'myApp.services',
    'myApp.controllers',
    'myApp.directives',
    'myApp.common',
    'myApp.routeConfig'
]

app = angular.module('myApp', dependencies)

angular.module('myApp.routeConfig', ['ngRoute'])
    .config(['$routeProvider', ($routeProvider) ->
        $routeProvider
            .when('/', {
                templateUrl: '/assets/partials/view.html'
            })
            .when('/label/xml/view', {
                templateUrl: '/assets/partials/view.html'
            })
            .when('/label/xml/create', {
                templateUrl: '/assets/partials/create.html'
            })
            .when('/label/xml/update/:xmlName/:xmlType', {
                templateUrl: '/assets/partials/update.html'
            })
            .when('/label/json/create', {
                templateUrl: '/assets/partials/createjson.html'
            })
            .when('/label/json/update/:jsonName/:jsonType', {
                 templateUrl: '/assets/partials/updatejson.html'
            })
            .otherwise({redirectTo: '/'})])
    .config(['$locationProvider', ($locationProvider) ->
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        })])

@commonModule = angular.module('myApp.common', [])
@controllersModule = angular.module('myApp.controllers', [])
@servicesModule = angular.module('myApp.services', [])
@modelsModule = angular.module('myApp.models', [])
@directivesModule = angular.module('myApp.directives', [])
@filtersModule = angular.module('myApp.filters', [])