package com.revature.reimbursement.Servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.User;

public class ProcessReimbServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute("current_user");
		int reimbId = Integer.parseInt(req.getParameter("reimbId"));
		int statusId = Integer.parseInt(req.getParameter("statusId"));
		Timestamp resolvedDate = new Timestamp(System.currentTimeMillis());;

		DataFacade df = new DataFacade();
		
		boolean isSuccess = df.processReimb(reimbId, statusId, user.getUserId(), resolvedDate);
		
		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(isSuccess) {
			resp.sendRedirect(req.getContextPath() + "/App/home");
		} else {
			req.getRequestDispatcher("/App/home.jsp").forward(req, resp);
		}
	}

}
