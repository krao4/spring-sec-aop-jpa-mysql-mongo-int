<html>
<head>
	<title>Home</title>
	<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<div ng-app="" ng-controller="policyController"> 

<br>
<br>
<br>
<br>
<button type="button" value="Click to invoke service!" title="Click" ng-click="onRefresh()">Refresh new page!</button>

</div>


<script>
function policyController($scope,$http) {
	
  	$scope.onRefresh = 
		function(){
  			window.location.href = 'http://localhost:8080/springapp/policy/list.html'
		}
  	
}
</script>

 

</body>
</html>
