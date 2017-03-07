package com.revature.reimbursement.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.User;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uName = req.getParameter("username");
		String pWord = req.getParameter("password");
		
		DataFacade df = new DataFacade();
		User user = df.getUserByUsername(uName);
		
		if(user.getUsername() != null){
			if (BCrypt.checkpw(pWord, user.getPassword())) {
				req.getSession().setAttribute("current_user", user);
				resp.sendRedirect("App/home");
			}
		} else {
			req.setAttribute("message", "Wrong Credentials");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("current_user") != null){
			resp.sendRedirect("App/home");
		}
		resp.sendRedirect("index.jsp");
	}
}
