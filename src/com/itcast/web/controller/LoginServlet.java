package com.itcast.web.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.DocumentException;

import com.itcast.bean.User;
import com.itcast.service.Service;
import com.itcast.service.impl.ServiceImpl;

/*
 * µÇÂ¼´¦ÀíServlet
 */
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		Service service=new ServiceImpl();
		try {
			User user=service.login(username, password);
			if (user!=null) {
				HttpSession session=req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
				return;
			}
			req.setAttribute("message", "µÇÂ¼Ê§°Ü!");
			req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
			return;
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
