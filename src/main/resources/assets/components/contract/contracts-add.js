  angular.module('contractApp')
    .controller('ContractsAdd', ['$scope', '$http', function($scope, $http, $location) {
      $scope.list = [];
      $scope.text = 'hello';
      $scope.submit = function() {
		  console.log($scope.contractcode);
		  console.log($scope.description);
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
        if ($scope.text) {
          $scope.list.push(this.text);
          $scope.text = '';
		  
		  
        }
      };
    }]);