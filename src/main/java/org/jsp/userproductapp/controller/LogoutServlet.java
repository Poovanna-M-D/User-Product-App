package org.jsp.userproductapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		req.getSession().invalidate();
		req.setAttribute("message", "You are Logged Out");
		RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
		dispatcher.forward(req, resp);
	}
}
