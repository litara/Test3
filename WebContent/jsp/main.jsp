<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Main page</title>

<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
<script src="bootstrap_js/bootstrap.bundle.min.js" defer></script>
<link rel="stylesheet" href="css/main.css">
</head>
<body class="bodyheight">

<div class="container">

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark mynavbar" style="padding: 0;" role="navigation">
		<div class="container-fluid">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" style="border: 0;" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end dropdown" id="collapsibleNavbar">
			<ul class="navbar-nav navbar-right">
				<li class="nav-item">
				<c:if test="${passenger!=null }">
						<a class="nav-link btn mybtn dropdown-toggle bg-dark" data-toggle="dropdown" href="#">${passenger.getEmail()}</a>
						<div class="dropdown-menu dropdown-menu-right mydropdown">
							<a class="dropdown-item mydropdown-item" href="controller?command=Logout">Выход</a>
						</div>
					</c:if> 
					<c:if test="${passenger==null}">
						<div class="dropdown">
							<button type="button" class="btn mybtn dropdown-toggle bg-dark text-light" data-toggle="dropdown">
    							Войти
  							</button>
  							<div class="dropdown-menu dropdown-menu-right mydropdown">
    							<form name=loginForm method="POST" action="controller">
    								<input type="hidden" name="command" value="login">
    								<input type="email" id="inputEmail" name="email" class="form-control myinput" placeholder="Email address">
    								<input type="password" name="password" class="form-control myinput" placeholder="Password">
    								<center><input type="submit" class="btn btn-primary" value="Войти"></center>
    							</form>
  							</div>
						</div>
					</c:if>
				</li>
			</ul>
		</div>
	</div>
	</nav>
</div>
	<c:if test="${not empty errorMessage}">
	<div class="container">
		<div class="alert alert-danger allert-dismissible errorMessages">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  			<strong>Danger!</strong> ${errorMessage}.
		</div>
	</div>
	</c:if>
	<div class="container">
		<div class="myimage">
			<h1>My First Bootstrap Page</h1>
		</div>
	</div>
</body>