(function (angular) {
    'use strict';

    var ngModule = angular.module('ReserveCabin', ['ReserveCabin.SearchCtrl']),
        cacheBustSuffix = new Date().getTime();

    // configure routing
    ngModule.config(['$routeProvider', function ($routeProvider) {
        // default route:
        $routeProvider.when('/', {templateUrl: 'angularjs/search/search.html?cache-bust=' + cacheBustSuffix, controller: 'SearchCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

}(window.angular));
