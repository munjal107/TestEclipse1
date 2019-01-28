<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller" method="post">
	<table>
		<tr>
			<td>User: </td>
			<td><input type="text" name="uname"><br/></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="pass" ><br/></td>
		</tr><tr>
			<td></td>
			<td><input type="submit" value="login" name="flag">
			<!-- <button type="button" onclick="Register.java">signup</button> -->	
			</td>
		</tr>
	</table>
	</form>
</body>
</html>