<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="stockApp">
<head>
<link rel="stylesheet" type="text/css" href="./common/bootstrap/bootstrap-3.3.4-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="./stock/directive/css/error.css">

<script src="common/jquery/jquery-1.11.3/jquery-1.11.3.min.js"></script>
<script src="common/bootstrap/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>

<script src="common/angularjs/angular-1.4.7/angular.js"></script>
<script src="common/angularjs/angular-1.4.7/angular.min.js"></script>
<script src="common/angularjs/angular-1.4.7/angular-route.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-resource.js"></script>

<script src="stock.js"></script>

<script src="stock/directive/error.js"></script>
<script src="stock/controller/markController.js"></script>

</head>
<body>
	<jsp:include page="stock/view/template/header.jsp" />

	<div class="main_container">	
		<jsp:include page="stock/view/page/register_mark.jsp" />
	</div>

</body>
</html>