(function () {
    'use strict';
	

    angular.module('contractApp', ['ngRoute'])
        .config(function ($routeProvider) {

            $routeProvider
                .when('/contracts',{controller: 'ContractsCtrl',controllerAs: 'ContractsCtrl',templateUrl:'/components/contract/index.html'})
				.when('/form',{controller: 'ContractsAdd',controllerAs: 'ContractsAdd',templateUrl:'/components/contract/form.html'})
                .otherwise({redirectTo: '/contracts'});
        });
})();