<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/resources/imgs/example.png" var="examplePNG"/>
<spring:url value="/resources/imgs/logo.png" var="logoPNG"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${stylesCSS}">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script src="https://sdk.amazonaws.com/js/aws-sdk-2.1.12.min.js"></script>

<link rel="shortcut icon" type="image/png" href="${logoPNG}" />

<title>Rocket Garage</title>
</head>

<noscript>
    <style type="text/css">
        .container {display:none;}
        nav{display:none;}
    </style>
    <div class="noscriptmsg">
<div class ="form-header" >
			<img src="${logoPNG}" style="width:400px;height:400px;" alt=""/>
			<br><br><br><br>
			<h1>We're sorry but to enjoy our site to the fullest you must enable JavaScript</h1>
</div>
    </div>
</noscript>



<body>
<div class = "container">
	<div class = "wrapper" >
		<div class ="form-header" >
			<img src="${logoPNG}" style="width:400px;height:400px;" alt=""/>
			<br><br><br><br>
			<h1>404: Page not found</h1>
</div>
	</div>
		</div>
</body>
</html>