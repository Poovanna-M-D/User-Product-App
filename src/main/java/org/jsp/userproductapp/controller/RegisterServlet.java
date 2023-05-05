package org.jsp.userproductapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.userproductapp.dao.UserDao;
import org.jsp.userproductapp.dto.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		int age  = Integer.parseInt(req.getParameter("age"));
		
		User u = new User();
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setAge(age);
		u.setGender(gender);
		u.setPassword(password);
		
		UserDao dao = new UserDao();
		u = dao.saveUser(u);
		
		PrintWriter writer = resp.getWriter();
		writer.print("<html><body><h2> User Registered With ID: "+ u.getId() + "</h2></body></html>");	
	}
}
