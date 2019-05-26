<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/resources/imgs/example.png" var="examplePNG"/>
<spring:url value="/resources/imgs/logo.png" var="logoPNG"/>
<spring:url value="/resources/css/styles.css" var="stylesCSS"/>


 
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

	<script type="text/javascript" src="<c:url value="/resources/scripts/shared.js" />"></script>


<nav  class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<span class="navbar-brand"><img src="${logoPNG}"
				style="width: 40px; height: 40px; margin-left: -10px; margin-top: -10px;"></span>
			<span class="navbar-brand" style="color:white">Rocket Garage</span>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
		
		<ul class="nav navbar-nav">
			 <li><form class="navbar-form" action="backtoGarage" method="post">
			 		<input type="hidden" value="home" name="location">
                    <button  type="submit" class="btn btn-primary" style="background:none;border:none;"><span class="glyphicon glyphicon-home"></span>&nbsp;My Garage</button>
                </form></li>
                <li><form class="navbar-form" action="toSharedRockets" method="post">
			 		<input type="hidden" value="home" name="location">
                    <button  type="submit" class="btn btn-primary" style="background:none;border:none;"><span class="glyphicon glyphicon-cloud"></span>&nbsp;Shared Rockets</button>
                </form></li>
	</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><form class="navbar-form" action="profile" method="post">
			 		<input type="hidden" value="user.jsp" name="location">
                    <button  type="submit" class="btn btn-primary" style="background:none;border:none;"><span class="glyphicon glyphicon-user"></span>&nbsp;${userName}</button>
                </form></li>
			
				<li><form class="navbar-form" action="logout" method="post">
			 		<input type="hidden" value="logout" name="location">
                    <button  type="submit" class="btn btn-primary" style="background:none;border:none;"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Logout</button>
                </form>
			</ul>
		</div>
	</div>
</nav>



	<div class="container">

		<div class="header">
			<h1>Shared Rockets</h1>
		</div>

			<div class="flex-container">
			
				<c:forEach var ="rocket" items="${sharedRockets}">
						
				<div class = "flex-item">
				<input class="id" type="hidden" value="${rocket.getRocketId()}"/>
				<img class="flex-nail" src="${rocket.getRocketPic()}"/>
				<div class="flex-name">${rocket.getRocketName()}</div>
				</div>
			
			</c:forEach>



			</div>

			<div class="button-panel">
				<button id="view-s" style="margin-top:220px;" class="btn btn-lg btn-primary option">View</button><br>
				<button id="send" class="btn btn-lg btn-primary option">Send to<br>Garage</button>
			</div>
			
			
			
			

	</div>


	<form id="go" action="nowhere" method="post">
		<input value="8" type = "hidden" id="f-layout" name="id">
	</form>


</body>
</html>