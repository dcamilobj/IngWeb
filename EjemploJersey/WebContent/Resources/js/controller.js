/**
 * 
 */
var module = angular.module('myModule',[]);
module.controller('myController',['$scope',
	function($scope)
	{
	  //Variable para cargar datos iniciales de la lista JSON
		$scope.list = [{texto: 'Prueba1', checked:true},
			{texto: 'Prueba2', checked:false}];
		
		$scope.add = function()
		{
			if(!$scope.text)
			{
				alert("Debe digitar el texto");
				return;
			}
			$scope.list.push({texto: $scope.text, checked:false});
			$scope.text = '';
		}
		$scope.delete = function()
		{	
			for(i = $scope.list.length -1; i>=0; i--)
			{
				if($scope.list[i].checked)
				{
					$scope.list.splice(i, 1);	
				}
			}
		}
	}]);