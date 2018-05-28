<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
<link rel="stylesheet" href="css/signin.css">
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
</head>
<body class="text-center">

<form name=loginForm method="POST" class="form-signin" action="controller">
		<input type="hidden" name="command" value="login">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</form>



<!-- <form name="loginForm" method="POST" action="controller">
<input type="hidden" name="command" value="login" />
Login:<br/>
<input type="text" name="login" value=""/>
<br/>Password:<br/>
<input type="password" name="password" value=""/>
<br/>
${errorLoginPassMessage}
<br/>
${wrongAction}
<br/>
${nullPage}
<br/>
<input type="submit" value="Log in"/>
</form><hr/>-->
</body></html>