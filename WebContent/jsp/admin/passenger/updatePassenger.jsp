<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="admin" class="container">
	<input type="hidden" name="do" value="doupdate">
	<input type="hidden" name="id" value="${id}">
	<input type="text" class="text" name="email" value="${email }">
	<input type="text" class="text" name="password" value="${password}">
	<input type="text" class="text" name="name" value="${name}">
	<select name="role">
	<c:if test="${role=='ADMIN' }">
		<option value="PASSENGER">Пассажир</option>
		<option selected value="ADMIN">Администратор</option>
	</c:if>
	<c:if test="${role=='PASSENGER' }">
		<option selected value="PASSENGER">Пассажир</option>
		<option value="ADMIN">Администратор</option>
	</c:if>
	</select>
	<input type="submit" class="btn" value="Сохранить">
	
	</form>

</body>
</html>