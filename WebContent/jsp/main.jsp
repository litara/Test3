<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Main page</title>
<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
<script src="bootstrap_js/bootstrap.bundle.min.js" defer></script>
</head>
<body>



<nav class="navbar navbar-expand-sm bg-dark navbar-dark container-fluid">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end dropdown" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item btn-group">
      	<c:if test="${not empty userLogin }">
      		<a class="nav-link btn btn-outline-success dropdown-toggle" data-toggle="dropdown" href="#">${userLogin}</a>
      		<div class="dropdown-menu">
    			<a class="dropdown-item" href="controller?command=Logout">Выход</a>
  			</div>
      	</c:if> 
      	<c:if test="${empty userLogin}">
      		<a class="nav-link btn btn-outline-danger" href="controller?command=LoginRedirect">Вход</a>
      	</c:if>
      </li>    
    </ul>
  </div>  
</nav>

<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>My First Bootstrap 4 Page</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>
</body>