<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

 
 <script type="text/javascript" src="<c:url value="/resources/scripts/login.js" />"></script>
 <div class = "container">
            <div class="wrapper">
            	<div class ="form-header" >
	                <h3 class="form-signin-heading text-center" style="color:white; font-size:30pt;" >
	                <img src="${logoPNG}" style="width:120px;height:120px;" alt=""/>                	
	                    <img id ="rocket" src="${examplePNG}" style="position:absolute;width:60px;height:60px;" alt=""/>
	                </h3>
	                  <h3 class="form-signin-heading text-center" style="color:white; font-size:30pt;" >
	                	Rocket Garage
	                </h3>
	                <hr class="spartan" style="width:80%;">
                </div>
                
                 <div id="login-div">
                <form action="home" method="post" class="form-signin">  
                
	                    <div class="input-group">
	                        <span class="input-group-addon" >
	                            <i class="glyphicon glyphicon-user"></i>
	                        </span>
	                       <input type="text" class="form-control" style="height:45px;" name="username" placeholder="Username" required="">
	                    </div>
	                    <div class="input-group">
	                        <span class="input-group-addon">
	                            <i class="glyphicon glyphicon-lock"></i>
	                        </span>
	                       <input type="password" class="form-control" style="height:47px;" name="password" placeholder="Password" required="">  
	                    </div>
	                    <button class="btn asd btn-lg btn-primary btn-block"  value="login" name="login" type="Submit">Login</button>
	                    
	                    <button class="btn btn-primary btn-block" style="margin-top:20px" name="register" type="button"  value="register">Register</button>
	                                      			
            	</form>
            </div> 
            
            <div id="register-div">
            <form method="post" action="newUser" class="form-signin" style="margin-top:0;">
						
						<div class="form-group">
							<label class="control-label" for="signupName">Username</label><span style="color:red;"></span>
							<input id="signupName" type="text" maxlength="50" class="form-control" name="regUsername">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmail">Email</label><span style="color:red;"></span>
							<input id="signupEmail" type="email" maxlength="50" class="form-control" name="regEmail">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Password</label><span style="color:red;"></span>
							<input id="signupPassword" type="password" maxlength="25" class="form-control"  length="40" name="regPassword">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPasswordagain">Password again</label>
							<input id="signupPasswordagain" type="password" maxlength="25" class="form-control">
						</div>
						<div class="form-group">
							<button id="signupSubmit" type="submit" class="btn btn-lg btn-primary btn-block">Sign up</button>
						</div>
					<button name="cancel-register" type="button" class="btn btn-primary btn-block">Cancel</button>
					</form>
				</div>	
                
            </div>
            
</div>


</body>
</html>