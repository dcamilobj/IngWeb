/**
 * Controlador para el cuestionario. 
 * @author Duban Camilo Bedoya (dcamilo.bedoya@udea.edu.co)
 */
var cuestionario = angular.module("modCuestionario",[]);
cuestionario.controller('contCuestionario',
		function($scope)
		{
			$scope.preguntas = [{
				id:1,
				texto: 'Pregunta 1',
				respuestaValida: 1,
				repuesta: null,
				estado: '',
				respuestas: [{id:1, texto: 'Respuesta 1.1'},
							 {id:2, texto: 'Respuesta 1.2'},
							 {id:3, texto: 'Respuesta 1.3'}]
			},{
				id:2,
				texto: 'Pregunta 2',
				respuestaValida: 2,
				repuesta: null,
				estado: '',
				respuestas: [{id:1, texto: 'Respuesta 2.1'},
							 {id:2, texto: 'Respuesta 2.2'},
							 {id:3, texto: 'Respuesta 2.3'}]
			},{
				id:3,
				texto: 'Pregunta 3',
				respuestaValida: 3,
				repuesta: null,
				estado: '',
				respuestas: [{id:1, texto: 'Respuesta 3.1'},
							 {id:2, texto: 'Respuesta 3.2'},
							 {id:3, texto: 'Respuesta 3.3'}]
			}];
			
			$scope.respuestasCorrectas=0;
			$scope.estadoUsuario = '';
			//Variable para mostrar el resultado sólo cuando se de clic en 'Calificar'
			$scope.finish = false;
			
			/*Validar respuestas*/
			$scope.validar = function()
			{	
				$scope.respuestasCorrectas=0;
				for(i = 0; i < $scope.preguntas.length; i++)
				{
					if($scope.preguntas[i].respuestaValida == $scope.preguntas[i].respuesta)
					{
						$scope.respuestasCorrectas++;
						$scope.preguntas[i].estado='OK';
					}
					else
					{
						$scope.preguntas[i].estado='ERROR';
					}
				}
				estadoUsuario();
				$scope.finish = true;
			}
			
			/*Para poner el gif correspondiente a las respuestas correctas*/
			function estadoUsuario(){
				var total = $scope.respuestasCorrectas/$scope.preguntas.length;
				if(total == 0)
				{
					$scope.estadoUsuario = 'looser';
				}
				else if(total == 1)
				{
					$scope.estadoUsuario = 'guru';
				}
				else
				{
					$scope.estadoUsuario = 'poor';
				}
			}
		});
