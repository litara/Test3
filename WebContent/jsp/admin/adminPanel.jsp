<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
<script src="bootstrap_js/bootstrap.bundle.min.js" defer></script>
<link rel="stylesheet" href="css/adminpanel.css">
</head>
<body class="body">
	<c:import url="/jsp/navbar.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div class="col-3 navigation container-fluid">
				<a class="mybtn btn-dark btn elementPanel" href="admin?do=passenger">Пассажиры</a>
				<button type="button" class="btn-dark btn elementPanel mybtn ">Поезда</button>
			</div>
			<div class="col-9 editing">
				<c:if test="${editPassenger==null and editTrains==null }">
					<h6>Поздравляю, вы находитесь в панеле админа.</h6>
				</c:if>
				<c:if test="${ editPassenger==true }">
					<c:import url="/jsp/admin/passenger/tablePassenger.jsp"></c:import>
					<c:if test="${update==true }">
						<c:import url="/jsp/admin/passenger/updatePassenger.jsp"></c:import>
					</c:if>
					<c:import url="/jsp/admin/passenger/createPassenger.jsp"></c:import>
				</c:if>
				<c:if test="${editTrains==true }">
					<c:import url="/jsp/admin/station/tableStation">
						
					</c:import>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>