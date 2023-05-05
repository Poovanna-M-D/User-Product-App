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
		
		<h1> EDIT PROFILE </h1> 
   <%
		User user = (User) session.getAttribute("user");
	    if(user!=null)
	    {
	%>
		 <form action="edit" method="post">
				<input type="hidden" name="id" value= "<%= user.getId() %>">
				
				Name: <input type="text" name="name" value="<%= user.getName() %>"> <br> <br>
				
				Phone: <input type="tel" name="phone" value="<%= user.getPhone()%>"> <br> <br>
				
				Email: <input type="email" name="email" value="<%= user.getEmail() %>"> <br> <br>
				    
				Age: <input type="number" name="age" value="<%= user.getAge() %>"> <br> <br>
				
				Gender: <input type="radio" name="gender" value="Male">Male 
				        <input type="radio" name="gender" value="Female">Female <br> <br>
				
				Password: <input type="password" name="password" value="<%= user.getPassword() %>"> <br> <br>
				
				<input type="submit" value="UPDATE">
		 </form>
	
	<% 
		}
	    else
	    {
	    	response.sendRedirect("Login.jsp");
	    }
	 %>

</body>
</html>