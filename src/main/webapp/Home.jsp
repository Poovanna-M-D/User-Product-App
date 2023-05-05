<%@page import="org.jsp.userproductapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>HOME PAGE</h1>
	<%
		User user = (User) session.getAttribute("user");
	    if(user!=null)
	    {
	%>
	<h2>
		Welcome <%= user.getName() %>
	</h2>
	
	<h3>
		<a href="EditUser.jsp"> EDIT PROFILE </a>
	</h3>
	
	<h3>
		<a href="ViewUser.jsp"> VIEW PROFILE </a>
	</h3>
	
	<h3> 
		<a href="AddProduct.jsp"> ADD PRODUCT </a>
	</h3>
	
	<h3>
		<a href="viewproducts"> VIEW PRODUCTS </a>
	</h3>
	
	<h3>
		<a href="delete"> DELETE PROFILE </a>
	</h3>
	
	<h3>
		<a href="logout"> LOGOUT </a>
	</h3>
	
	
	<% 
		}
	    else
	    {
	    	response.sendRedirect("Login.jsp");
	    }
	 %>

</body>
</html>