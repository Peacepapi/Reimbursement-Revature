package com.revature.reimbursement.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;

@MultipartConfig
public class CreateReimbServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("current_user");

		if (user.getUserRole().getUserRoleId() != 1) {
			resp.sendRedirect(req.getContextPath() + "/App/home");
		}
		DataFacade df = new DataFacade();
		
		try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ReimbursementType> types = df.getAllReimbType();
		req.setAttribute("types", types);
		req.getRequestDispatcher("/App/reimbForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		System.out.println(isMultipart);

		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {
			double amount = 0;
			String desc = "";
			int typeId = -1;
			User user = (User) req.getSession().getAttribute("current_user");
			Timestamp submitted = new Timestamp(System.currentTimeMillis());

			List<FileItem> items = upload.parseRequest(req);

			Iterator<FileItem> iter = items.iterator();
			InputStream is = null;

			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					System.out.println(item.getFieldName());
					if (item.getFieldName().equals("amount"))
						amount = Double.parseDouble(item.getString());
					else if (item.getFieldName().equals("description"))
						desc = item.getString();
					else if (item.getFieldName().equals("typeId"))
						typeId = Integer.parseInt(item.getString());
				} else {
					is = item.getInputStream();

				}
			}

			DataFacade df = new DataFacade();
			boolean isSuccess = df.createReimbRequest(amount, desc, submitted, user.getUserId(), typeId, is);
			
			df.close();
			
			if (isSuccess) {
				resp.sendRedirect(req.getContextPath() + "/App/home");
			} else {
				req.getRequestDispatcher("/ReimbCreate").forward(req, resp);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
