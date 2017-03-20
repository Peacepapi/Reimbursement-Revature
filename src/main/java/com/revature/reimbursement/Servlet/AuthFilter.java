package com.revature.reimbursement.Servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servReq = (HttpServletRequest) req;
		if(servReq.getSession().getAttribute("current_user") == null){
			req.setAttribute("message", "Please login to continue");
			req.getRequestDispatcher("/login").forward(req, resp);
		} else {
			// expires cache, so back button won't work
			((HttpServletResponse) resp).setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			((HttpServletResponse) resp).setHeader("Pragma", "no-cache"); // HTTP 1.0.
			((HttpServletResponse) resp).setDateHeader("Expires", 0);
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
