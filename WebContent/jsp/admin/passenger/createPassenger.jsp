<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h2>Создать пассажира</h2>
	<form method="post" action="admin">
	<input type="hidden" name="do" value="create">

	<input type="text" class="text" name="email" placeholder="Email">
	<input type="text" class="text" name="password" placeholder="Password">
	<input type="text" class="text" name="name" placeholder="Name">
	<select name="role">
		<option selected value="PASSENGER">Пассажир</option>
		<option value="ADMIN">Администратор</option>
	</select>
	<input type="submit" class="btn" value="Создать">
	
	</form>
	</div>
</body>
</html>