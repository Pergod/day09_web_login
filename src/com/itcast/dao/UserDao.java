package com.itcast.dao;

import java.text.ParseException;

import org.dom4j.DocumentException;

import com.itcast.bean.User;

public interface UserDao {

	public void add(User user);

	public User find(String username, String password) throws DocumentException, ParseException;

	public Boolean find(String username) throws DocumentException;

}