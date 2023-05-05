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
		<h1> PROFILE DETAILS </h1> 
	 <%
		User user = (User)session.getAttribute("user");
	    if(user!=null)
	    {
	%>
	
		<h2>  ID: <%= user.getId() %>  </h2>
		
		<h2>  Name: <%= user.getName() %>  </h2>
		
		<h2>  Phone: <%= user.getPhone() %>  </h2>
		
		<h2>  Email: <%= user.getEmail() %>  </h2>
		
		<h2>  Age: <%= user.getAge() %>  </h2>
		
		<h2>  Gender: <%= user.getGender() %>  </h2>
			
	<% 
		}
	    else
	    {
	    	response.sendRedirect("Login.jsp");
	    }
	 %>

</body>
</html>