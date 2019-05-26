<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="resources/imgs/example.png" var="examplePNG" />
<spring:url value="resources/imgs/logo.png" var="logoPNG" />
<spring:url value="/resources/css/styles.css" var="stylesCSS" />

<spring:url value="resources/imgs/shapes/blackSquare.png"
	var="blackSquare" />
<spring:url value="resources/imgs/shapes/blueSquare.png"
	var="blueSquare" />
<spring:url value="resources/imgs/shapes/graySquare.png"
	var="graySquare" />
<spring:url value="resources/imgs/shapes/greenSquare.png"
	var="greenSquare" />
<spring:url value="resources/imgs/shapes/magentaSquare.png"
	var="magentaSquare" />
<spring:url value="resources/imgs/shapes/orangeSquare.png"
	var="orangeSquare" />
<spring:url value="resources/imgs/shapes/pinkSquare.png"
	var="pinkSquare" />
<spring:url value="resources/imgs/shapes/redSquare.png" var="redSquare" />
<spring:url value="resources/imgs/shapes/white.png" var="white" />
<spring:url value="resources/imgs/shapes/yellowSquare.png"
	var="yellowSquare" />
<spring:url value="resources/imgs/shapes/blackTri.png" var="blackTri" />
<spring:url value="resources/imgs/shapes/blueTri.png" var="blueTri" />
<spring:url value="resources/imgs/shapes/grayTri.png" var="grayTri" />
<spring:url value="resources/imgs/shapes/greenTri.png" var="greenTri" />
<spring:url value="resources/imgs/shapes/mengentaTri.png"
	var="mengentaTri" />
<spring:url value="resources/imgs/shapes/orangeTri.png" var="orangeTri" />
<spring:url value="resources/imgs/shapes/pinkTri.png" var="pinkTri" />
<spring:url value="resources/imgs/shapes/redTri.png" var="redTri" />
<spring:url value="resources/imgs/shapes/whiteTri.png" var="whiteTri" />
<spring:url value="resources/imgs/shapes/yellowTri.png" var="yellowTri" />




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${stylesCSS}">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://sdk.amazonaws.com/js/aws-sdk-2.1.12.min.js"></script>
<link rel="shortcut icon" type="image/png" href="${logoPNG}" />

<title>Rocket Garage</title>
</head>

<noscript>
	<style type="text/css">
.container {
	display: none;
}

nav {
	display: none;
}
</style>
	<div class="noscriptmsg">
		<div class="form-header">
			<img src="${logoPNG}" style="width: 400px; height: 400px;" alt="" />
			<br>
			<br>
			<br>
			<br>
			<h1>We're sorry but to enjoy our site to the fullest you must
				enable JavaScript</h1>
		</div>
	</div>
</noscript>



<body>

	<script type="text/javascript"
		src="<c:url value="/resources/scripts/build.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/html2canvas.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/FileSaver.min.js" />"></script>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<span class="navbar-brand"><img src="${logoPNG}"
				style="width: 40px; height: 40px; margin-left: -10px; margin-top: -10px;"></span>
			<span class="navbar-brand" style="color: white">Rocket Garage</span>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">

			<ul class="nav navbar-nav">
				<li><form class="navbar-form" action="backtoGarage" method="post">
						<input type="hidden" value="home" name="location">
						<button type="submit" class="btn btn-primary"
							style="background: none; border: none;">
							<span class="glyphicon glyphicon-home"></span>&nbsp;My Garage
						</button>
					</form></li>
				<li><form class="navbar-form" action="toSharedRockets" method="post">
						<input type="hidden" value="home" name="location">
						<button type="submit" class="btn btn-primary"
							style="background: none; border: none;">
							<span class="glyphicon glyphicon-cloud"></span>&nbsp;Shared
							Rockets
						</button>
					</form></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><form class="navbar-form" action="profile" method="post">
						<input type="hidden" value="user.jsp" name="location">
						<button type="submit" class="btn btn-primary"
							style="background: none; border: none;">
							<span class="glyphicon glyphicon-user"></span>&nbsp;${userName}
						</button>
					</form></li>

				<li><form class="navbar-form" action="logout" method="post">
						<input type="hidden" value="logout" name="location">
						<button type="submit" class="btn btn-primary"
							style="background: none; border: none;">
							<span class="glyphicon glyphicon-log-in"></span>&nbsp;Logout
						</button>
					</form>
			</ul>
		</div>
	</div>
	</nav>



	<div class="container">

		<div class="instructions">
			<h2>Instructions</h2>
			<br>
			<p>1) Drag shapes into the grid to build a rocket</p>
			<br>
			<p>2) Click placed shapes to rotate them</p>
			<br>
			<p>3) Drag a placed shape to create a duplicate</p>
			<br>
			<p>4) Hold Ctrl and drag a placed shape to move it</p>
			<br>
			<p>5) Click a tile and press the Delete key to delete a shape
			<p>6) Have fun!</p>

		</div>

		<div class="build">



			<div class="build-view">



				<div id="grid"></div>

				<div id="palet">
					<img id="drag1" class="palet-item north" src="${blackSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag3" class="palet-item north" src="${blueSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag5" class="palet-item north" src="${graySquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag7" class="palet-item north" src="${greenSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag9" class="palet-item north" src="${magentaSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag11" class="palet-item north" src="${orangeSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag13" class="palet-item north" src="${pinkSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag15" class="palet-item north" src="${redSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag17" class="palet-item north" src="${white}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag19" class="palet-item north" src="${yellowSquare}"
						draggable="true" ondragstart="drag(event)" width="30" height="30"><br>
					<img id="drag2" class="palet-item north" src="${blackTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag4" class="palet-item north" src="${blueTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag6" class="palet-item north" src="${grayTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag8" class="palet-item north" src="${greenTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag10" class="palet-item north" src="${mengentaTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag12" class="palet-item north" src="${orangeTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag14" class="palet-item north" src="${pinkTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag16" class="palet-item north" src="${redTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag18" class="palet-item north" src="${whiteTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">
					<img id="drag20" class="palet-item north" src="${yellowTri}"
						draggable="true" ondragstart="drag(event)" width="30" height="30">

				</div>


			</div>

		</div>


		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content"
					style="background-color: rgba(232, 44, 44, .9)">

					<div class="modal-body">


						<form>
							<div class="form-group">
								<label class="control-label" for="name">Name your
									rocket:</label> <input id="Rname" type="text" maxlength="50"
									class="form-control">
							</div>

							<div class="modal-footer">
								<button type="button" id="saveSub" class="btn btn-default"
									data-dismiss="modal">Submit</button>
							</div>
						</form>

					</div>
				</div>

			</div>
		</div>
		
		
		
		
		<div class="modal fade" id="downModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content"
					style="background-color: rgba(232, 44, 44, .9)">

					<div class="modal-body">


						<form>
							<div class="form-group">
								<label class="control-label" for="name">Name your
									picture:</label> <input id="downName" type="text" maxlength="50"
									class="form-control">
							</div>

							<div class="modal-footer">
								<button type="button" id="downSub" class="btn btn-default"
									data-dismiss="modal">Submit</button>
							</div>
						</form>

					</div>
				</div>

			</div>
		</div>
		


		<div class="button-panel" style="float: right; margin-top: 110px;">
		<form action ="backtoGarage" method="post">
			<button id="back" style="margin-top: 80px;"
				class="btn btn-lg btn-primary option" type="submit">
				Back to<br>Garage
			</button>
		</form>
			
			<button id="save" data-toggle="modal" data-target="#myModal"
				class="btn btn-lg btn-primary option">Save</button>
			<br><br>
			<button id="down" data-toggle="modal" data-target="#downModal" style="background-color:blue" class="btn btn-lg btn-primary option"><span class="glyphicon glyphicon-download-alt"> </span></button><br>
		</div>

	</div>

	<span style="display:none" id ="layout">${rocket}</span>
	<span style="display:none" id ="level">${level}</span>

</body>
</html>