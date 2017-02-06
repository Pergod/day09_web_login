package com.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itcast.bean.User;
import com.itcast.exception.UserExistException;
import com.itcast.service.Service;
import com.itcast.service.impl.ServiceImpl;
import com.itcast.utils.WebUtils;
import com.itcast.web.formbean.RegisterForm;import com.sun.org.apache.bcel.internal.generic.NEW;
/*
 * 注册处理Servlet
 */
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//1.表单字段合法性校验(把表单数据封装到formbean)
		RegisterForm form=WebUtils.request2Bean(req,RegisterForm.class);
		boolean b=form.validate();
		//1.1 校验失败，跳回表单页面,回写校验信息
		if (!b) {
			req.setAttribute("message", form);
			req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
			return;
		}
		//1.2 校验成功,交由Service处理
		Service service=new ServiceImpl();
		User user=new User();
		WebUtils.copyBean(form, user);
		String id=WebUtils.generateID();
		user.setId(id);
		try {
			service.regsiter(user);
			req.setAttribute("message", "恭喜你，注册成功");
			req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req, resp);
			return;
		}  catch (UserExistException e) {
//			req.setAttribute("message", "注册用户已存在");
			
			form.getErrors().put("username",  "注册用户已存在");
			req.setAttribute("message", form);
			req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
			return;
		}catch (Exception e) {
//			req.setAttribute("message", "服务器出现未知故障");
			
			form.getErrors().put("message",  "服务器出现未知故障");
			req.setAttribute("message", form);
			req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
			e.printStackTrace();
		}
		//1.2.1 Service处理失败,跳回注册页面，回写注册用户已存在信息; 或其它异常信息,跳转全局消息显示页面
		
		//1.2.2 Service处理成功,添加用户,跳转全局显示页面
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
