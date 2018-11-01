stockApp.controller('markController', ['$scope', '$http', '$location', function($scope, $http, $location) {

	var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/stock/rest/marks";

	$scope.mark = {};
	//$scope.getAll();   
	
	$scope.save = function(mark){
		$scope.$broadcast('show-errors-check-validity');
	
		if ($scope.form.$valid) {
			$scope.$broadcast('show-errors-reset');
		}

		if(mark != null){
			$http.post(url+"/save", mark).success(function(data, status) {		   
				cleanForm();		
			}).error(function(data, status, headers, config) {

			});		      		   				
		}  		
	} 

	$scope.updade = function(mark){
		$scope.$broadcast('show-errors-check-validity');
   		if ($scope.form.$valid) {   		
   			
   			if(mark != null && mark.id > 0){   		      			   				
			   $http.put(url+"/"+ mark).success(function(data, status) {		   		
			   		cleanForm();		
			   }).error(function(data, status, headers, config) {
			     
			   });
			   
	   		}
   			
	   		$scope.$broadcast('show-errors-reset');
   		}  
	}
	
	 $scope.excluir = function(id){
		   delete(url+"/"+id).success(function(data, status) {	   		
		   		$scope.getAll(); 		   		
		   }).error(function(data, status, headers, config) {
		     
		   });
	   };
	
	   
	$scope.getAll = function(){
		$http.get(url).success(function(data, status) {	   		
			return $scope.marks = data;
		}).error(function(data, status, headers, config) {

		});	   
	};
	
	$scope.getForUpdate = function(id){
		$http.get(url+"/"+id).success(function(data, status){
			$scope.mark = data;
		}).error(function(data, status, headers, config){

		});
	};	
	
	var cleanForm = function(){
		$scope.mark = {};   	
	}  
	
}]);