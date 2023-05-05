<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
       
<body>
       <h1>Enter the Product Details </h1>
	<form action="addproduct" method="post">
	
		Name<input type="text" name="name"> <br><br>
		
		Brand<input type="text" name="brand"> <br><br>
		
		Description<input type="text" name="description"> <br><br>
		
		Category<input type="text" name="category"> <br><br>
		
		Price<input type="text"" name="price"> <br><br>
		
		Image<input type="text" name='image'> <br><br><br>
		
	    	<input type="submit" value="ADD PRODUCT">
	</form>

</body>
</html>