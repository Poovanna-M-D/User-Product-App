package org.jsp.userproductapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.userproductapp.dao.UserDao;
import org.jsp.userproductapp.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		
		UserDao dao = new UserDao();
		User u = dao.verifyUser(phone, password);	
		
		RequestDispatcher dispatcher = null;
		PrintWriter writer = resp.getWriter();
		
		if(u!=null)
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			dispatcher = req.getRequestDispatcher("Home.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			writer.print("<html><body><h2> Invalid Phone Number Or Password </h2></body></html>");
			dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.include(req, resp);	
		}
	}
	

}
