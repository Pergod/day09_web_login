package com.itcast.service;

import java.text.ParseException;

import org.dom4j.DocumentException;

import com.itcast.bean.User;
import com.itcast.exception.UserExistException;

public interface Service {

	//зЂВс
	public void regsiter(User user) throws DocumentException, UserExistException;

	public User login(String username, String password) throws DocumentException, ParseException;

}