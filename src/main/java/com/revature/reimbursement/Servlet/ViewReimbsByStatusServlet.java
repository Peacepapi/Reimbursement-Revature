package com.revature.reimbursement.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.Reimbursement;

public class ViewReimbsByStatusServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("statusId") == null) {
			resp.sendRedirect(req.getContextPath() + "/App/home");
		}
		
		int id = Integer.parseInt(req.getParameter("statusId"));
		System.out.println(id);
		DataFacade df = new DataFacade();
		
		List<Reimbursement> allReimb = df.getReimbByStatus(id);
		
		req.setAttribute("reimbList", allReimb);
		req.getRequestDispatcher("/App/home.jsp").forward(req, resp);
	}
}
