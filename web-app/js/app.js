(function (angular) {
    'use strict';

    var ngModule = angular.module('reservecabin', ['reservecabin.main']),
        cacheBustSuffix = new Date().getTime();

    ngModule.constant('cacheBustSuffix', cacheBustSuffix);

    // configure routing
    ngModule.config(['$routeProvider', function ($routeProvider) {
        // default route:
        $routeProvider.when('/', {templateUrl: 'index.html?cache-bust=' + cacheBustSuffix, controller: 'MainCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

}(window.angular));
