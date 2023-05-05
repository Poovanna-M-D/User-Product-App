//When we click on Edit in ViewProducts we have to first Find the Product and then Edit the Product
//Project Flow (FindProductServlet -> EditProduct.jsp -> EditProductServlet)

package org.jsp.userproductapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.userproductapp.dao.ProductDao;
import org.jsp.userproductapp.dto.Product;
import org.jsp.userproductapp.dto.User;


@WebServlet("/editproduct")
public class EditProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		double price = Double.parseDouble(req.getParameter("price"));
		String image = req.getParameter("image");
		
		Product p = new Product(name, brand, description, category, price, image);
		p.setId(id);
		
		ProductDao dao = new ProductDao();
		User u = (User) req.getSession().getAttribute("user");
		p = dao.updateProduct(p, u.getId());
		
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body><h2>Product Edited with ID:" + p.getId() + "</h2></body></html>");
	}

}
