package com.revature.reimbursement.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.reimbursement.DAO.DataFacade;

public class RetrieveImageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("id") == null) {
			resp.sendRedirect(req.getContextPath() + "/App/home");
		}
		
		int id = Integer.parseInt(req.getParameter("id"));
		DataFacade df = new DataFacade();
		
		Blob blob = df.getImageById(id);
		
		byte[] bb = null;
		
		try {
			bb = blob.getBytes(1, (int) blob.length());
			resp.getOutputStream().write(bb);
		} catch (SQLException e) {
			System.out.println("From catch");
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/App/home");
		} finally {
			try {
				df.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
