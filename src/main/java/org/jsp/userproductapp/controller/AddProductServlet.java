package org.jsp.userproductapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.userproductapp.dao.ProductDao;
import org.jsp.userproductapp.dto.Product;
import org.jsp.userproductapp.dto.User;

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		double price = Double.parseDouble(req.getParameter("price"));
		String image = req.getParameter("image");
		
		Product p = new Product(name, brand, description, category, price, image);
		
		ProductDao dao = new ProductDao();
		User u = (User) req.getSession().getAttribute("user");
		p = dao.saveProduct(p, u.getId());
	
		PrintWriter writer = resp.getWriter();
		writer.print("<html><body><h2>Product Added Successfully with ID:" + p.getId() + "</h2></body></html>");	
	}
}
