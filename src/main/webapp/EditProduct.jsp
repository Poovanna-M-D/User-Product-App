<%@page import="org.jsp.userproductapp.dto.User"%>
<%@page import="org.jsp.userproductapp.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <h1>Edit Product Details</h1>
	<%
		User user = (User) session.getAttribute("user");
		if (user != null) 
		{
			Product p = (Product) request.getAttribute("product");
	%>
	
		<form action="editproduct" method="post">
			<input type="hidden" value="<%=p.getId()%>" name="id">
			
			Name:<input	type="text" name="name" value="<%=p.getName()%>"> <br><br>
			
			Brand:<input type="text" name="brand" value="<%=p.getName()%>"> <br><br>
	
			Description:<input type="text" name="description" value="<%=p.getDescription()%>"> <br><br> 
			
			Category:<input type="text" name="category" value="<%=p.getCategory()%>"> <br><br>
			
			Price:<input type="number" name="price" value="<%=p.getPrice()%>"> <br><br>
	
			Image:<input type="text" name="image" value="<%=p.getImage()%>"> <br><br>
	
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