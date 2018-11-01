//'use strict';
var taskApp = angular.module('stockApp', ['ngRoute']);

taskApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/stock', {
        templateUrl: 'stock/view/page/register_mark.jsp',
        controller: 'markController'
    }).otherwise({redirectTo: '/stock'});
    
}]);
