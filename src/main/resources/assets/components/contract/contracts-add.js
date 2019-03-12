  angular.module('contractApp')
    .controller('ContractsAdd', ['$scope', '$http','$location', function($scope, $http, $location) {

      $scope.submit = function() {
		  $http.post('/api/form', {
			  contractcode:$scope.contractcode,
			  description:$scope.description,
			  vendor:$scope.vendor,
			  percentComplete:$scope.percentComplete,
			  budget:$scope.budget,
			  payment:$scope.payment,
			  forecast:$scope.forecast,
			  committed:$scope.committed
		  }	).success(function(response) { $location.path('/api/contracts')});

      };
    }]);