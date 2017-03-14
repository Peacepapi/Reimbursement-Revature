package com.revature.reimbursement.Servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.User;

public class ViewAllReimbServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute("current_user");
		
		DataFacade df = new DataFacade();
		
		List<Reimbursement> allReimb = new ArrayList<Reimbursement>();
		
		if(user.getUserRole().getUserRoleId() == 1){
			allReimb = df.getReimbByUser(user.getUserId());
		} else {
			allReimb = df.getAllReimb();
		}
		
		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("reimbList", allReimb);
		req.getRequestDispatcher("/App/home.jsp").forward(req, resp);;
	}
}
