<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SPORTY SHOES</h3>
${requestScope.msg}
<form action="checkLoginDetails" method="post">
	<label>Email</label> &nbsp;&nbsp;&nbsp;
	<input type="email" name="email"><br/>
	<label>Password</label>
	<input type="password" name="password"><br/>
	<label>TypeOfUser</label>
	<input type="radio" name="typeOfUser" value="user"/>User
	<input type="radio" name="typeOfUser" value="admin"/>Admin
	<br/>
	<input type="submit" value="submit"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="signUp.jsp">SignUp</a>
</body>
</html>