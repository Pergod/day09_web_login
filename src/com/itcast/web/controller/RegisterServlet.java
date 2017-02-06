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
 * ע�ᴦ��Servlet
 */
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//1.���ֶκϷ���У��(�ѱ����ݷ�װ��formbean)
		RegisterForm form=WebUtils.request2Bean(req,RegisterForm.class);
		boolean b=form.validate();
		//1.1 У��ʧ�ܣ����ر�ҳ��,��дУ����Ϣ
		if (!b) {
			req.setAttribute("message", form);
			req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
			return;
		}
		//1.2 У��ɹ�,����Service����
		Service service=new ServiceImpl();
		User user=new User();
		WebUtils.copyBean(form, user);
		String id=WebUtils.generateID();
		user.setId(id);
		try {
			service.regsiter(user);
			req.setAttribute("message", "��ϲ�㣬ע��ɹ�");
			req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req, resp);
			return;
		}  catch (UserExistException e) {
//			req.setAttribute("message", "ע���û��Ѵ���");
			
			form.getErrors().put("username",  "ע���û��Ѵ���");
			req.setAttribute("message", form);
			req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
			return;
		}catch (Exception e) {
//			req.setAttribute("message", "����������δ֪����");
			
			form.getErrors().put("message",  "����������δ֪����");
			req.setAttribute("message", form);
			req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
			e.printStackTrace();
		}
		//1.2.1 Service����ʧ��,����ע��ҳ�棬��дע���û��Ѵ�����Ϣ; �������쳣��Ϣ,��תȫ����Ϣ��ʾҳ��
		
		//1.2.2 Service����ɹ�,����û�,��תȫ����ʾҳ��
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
