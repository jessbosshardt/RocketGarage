<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import= "com.revature.beans.User" %>
<spring:url value="/resources/imgs/example.png" var="examplePNG"/>
<spring:url value="/resources/imgs/logo.png" var="logoPNG"/>
<spring:url value="/resources/css/styles.css" var="stylesCSS"/>
 <%
session = request.getSession();
if(!(null == session.getAttribute("user")))
{
    User user = new User();
    user = (User)session.getAttribute("user");
}
%>
 
 
 
 
 
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
    <script type="text/javascript" src="<c:url value="/resources/scripts/admin.js" />"></script>
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
        <div style="display:inline;" class="header">
            <h1>Admin <span id="status" style="margin-left:200px;text-align:center;">Flagged Rockets</span></h1>    
        </div>
        
        
        <div style="display:inline;" class="admin-div">
            <div style="margin-top:20px; width:50%;" class="flex-container">
            <c:forEach var ="rocket" items="${flaggedRockets}">
                        
                <div class = "flex-item">
                <input type="hidden" class="flaggedId" value="${rocket.getRocketId()}"/>
                <img class="flex-nail" src="${rocket.getRocketPic()}"/>
                <div class="flex-name">${rocket.getRocketName()}</div>
                </div>
            
            </c:forEach>
            </div>
        
    
    
    
    
        <table id="usertab" class = "table" style=" height:200px;">
        <tbody style="display:block;overflow-y:scroll; "> 
            <tr>
            <td><strong>Username</strong></td>
            <td><strong>User Role</strong></td>
            </tr>
        
            <c:forEach var ="user" items="${users}">
                <tr id = "${user.getId()}">
                    <td>${user.getUsername()}</td>
                    <td>
                        <p class ="${user.getId()}">
                            ${user.getUserRole()}
                        </p>
                    </td>
                    <td>
                            <input type="hidden" name="userDeleteId" value="${user.getId()}"/>
                            <button class="btn btn-primary" name="deleteButton">delete</button>
                    </td>
                    <td>
                            <input type="hidden" name="userPromoteId" value="${user.getId()}"/>
                            <button class="btn btn-primary" name="promoteButton">promote</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
            <div style="margin-top:320px;" class="button-panel">
                <button id="delete" data-toggle="modal" data-target="#deleteSure"  class="btn btn-lg btn-primary option">Delete</button><br>
                <button id="unflag" data-toggle="modal" data-target="#pardonSure" style="font-size:10pt;" class="btn btn-lg btn-primary option">Remove<br>Flag</button><br>
            </div>
                
                
 <div class="modal fade" id="deleteSure" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" style="background-color:rgba(232, 44, 44, .9)">
        <div class="modal-body">
            
            
        <form>
        Are you sure that you want to delete?
            
        <div class="modal-footer">
          <button type="button" id="deleteFlagged" class="btn btn-default" data-dismiss="modal">Yes</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
        </div>
        </form>
        
        </div>
      </div>
      
    </div>
  </div>
  
  <div class="modal fade" id="pardonSure" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" style="background-color:rgba(232, 44, 44, .9)">
        <div class="modal-body">
            
            
        <form>
        Are you sure that you want to remove flag?
            
        <div class="modal-footer">
          <button type="button" id="removeFlag" class="btn btn-default" data-dismiss="modal">Yes</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
        </div>
        </form>
        
        </div>
      </div>
    </div>
  </div>
</div>
    <form id="go" action="nowhere" method="post">
        <input value="8" type = "hidden" id="f-layout" name="id">
    </form>
</body>
</html>