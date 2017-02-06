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
	
	//Spring 工厂设计模式
	private UserDao dao=new UserDaoImpl();
	
	//注册
	@Override
	public void regsiter(User user) throws DocumentException, UserExistException{
		//先判断用户是否存在
		Boolean flag=dao.find(user.getUsername());
		if (!flag) {
			user.setPassword(ServiceUtils.MD5(user.getPassword()));//密码加密
			dao.add(user);
		}else {
			throw new UserExistException();//向web层抛异常,用户已注册
		}
	}
	
	@Override
	public User login(String username,String password) throws DocumentException, ParseException {
		return dao.find(username, ServiceUtils.MD5(password));
	}
}
