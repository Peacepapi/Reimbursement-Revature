package com.revature.reimbursement.Servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;

public class CreateReimbServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("current_user");
		
		if(user.getUserRole().getUserRoleId() != 1) {
			resp.sendRedirect(req.getContextPath() + "/App/home");
		}
		DataFacade df = new DataFacade();
		
		List<ReimbursementType> types = df.getAllReimbType();
		System.out.println(types);
		req.setAttribute("types", types);
		req.getRequestDispatcher("/App/reimbForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		double amount = Double.parseDouble(req.getParameter("amount")); 
		String desc = req.getParameter("description");
		int typeId = Integer.parseInt(req.getParameter("typeId"));
		User user = (User) req.getSession().getAttribute("current_user");
        Timestamp submitted = new Timestamp(System.currentTimeMillis());
        
        
//        List<Part> filePart = req.getParts().stream().filter(predicate)
//        String fileName = Paths.get(filePart.gets, more)
        
        
		DataFacade df = new DataFacade();
		
		boolean isSuccess = df.createReimbRequest(amount, desc, submitted, user.getUserId(), typeId);
		System.out.println(isSuccess);
		if(isSuccess) {
			resp.sendRedirect(req.getContextPath() + "/App/home");
		} else {
			req.getRequestDispatcher("/ReimbCreate").forward(req, resp);
		}
	}
}
