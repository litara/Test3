<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Basic Table</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Email</th>
					<th>Пароль</th>
					<th>Имя</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tablePassengers}" var="i">

					<tr>
						<td>${i.getEmail()}</td>
						<td>${i.getPassword()}</td>
						<td>${i.getName()}</td>
						<td>
						<form method="POST" action="admin">
							<input type="hidden" name="do" value="del"/>
							<input type="submit" class="btn" value="Delete">
							<input type="hidden" name="id" value="${i.getId()}"/>
						</form>
						</td>
						<td>
							<form action="admin" method="post">
								<input type="hidden" name="do" value="update">
								<input type="hidden" name="id" value="${i.getId()}">
								<input type="hidden" name="email" value="${i.getEmail() }">
								<input type="hidden" name="password" value="${i.getPassword() }">
								<input type="hidden" name="name" value="${i.getName() }">
								<input type="hidden" name="role" value="${i.getRole() }">
								<input type="submit" class="btn" value="Update">
							</form>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>