<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  
	<h1>Registration Form</h1>
	<form action="register" method="post">

		Name:<input type="text" name="name"> <br> <br>
		Phone:<input type="tel" name="phone" > <br> <br>
		Email:<input type="email" name="email" > <br> <br>
		Age:<input type="number" name="age"> <br> <br>
		Gender:<input type="radio" name="gender" value="Male">Male
		       <input type="radio" name="gender" value="Female">Female 
		<br><br>
		Password<input type="password" name="password"> <br>
		<br>
	
		<input type="submit" value="REGISTER">
	</form>
</body>
</html>