<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	${message}
	<form action="login.php" method="post">
		<div>
			<label>Username</label> <input type="text" name="id" value="${cookie['uid'].value }">
		</div>
		<div>
			<label>Password</label> <input type="password" name="password" value="${cookie['cpw'].value }">
		</div>
		<div>
			<label> <input name="remember" type="checkbox">
				Remember me</label>

		</div>
		<div>
			<button>Login</button>
		</div>
	</form>
</body>
</html>