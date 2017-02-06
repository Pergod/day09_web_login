package com.itcast.service.impl;

import java.text.ParseException;

import org.dom4j.DocumentException;

import com.itcast.bean.User;
import com.itcast.dao.UserDao;
import com.itcast.dao.impl.UserDaoImpl;
import com.itcast.exception.UserExistException;
import com.itcast.service.Service;
import com.itcast.utils.ServiceUtils;

import sun.security.provider.MD5;

public class ServiceImpl implements Service {
	
	//Spring �������ģʽ
	private UserDao dao=new UserDaoImpl();
	
	//ע��
	@Override
	public void regsiter(User user) throws DocumentException, UserExistException{
		//���ж��û��Ƿ����
		Boolean flag=dao.find(user.getUsername());
		if (!flag) {
			user.setPassword(ServiceUtils.MD5(user.getPassword()));//�������
			dao.add(user);
		}else {
			throw new UserExistException();//��web�����쳣,�û���ע��
		}
	}
	
	@Override
	public User login(String username,String password) throws DocumentException, ParseException {
		return dao.find(username, ServiceUtils.MD5(password));
	}
}
