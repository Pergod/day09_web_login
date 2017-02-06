package com.itcast.dao.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.itcast.bean.User;
import com.itcast.dao.UserDao;
import com.itcast.utils.XMLUtils;

public class UserDaoImpl implements UserDao {
	
	public void add(User user){
		try {
			Document document=XMLUtils.getDocument();
			Element root=document.getRootElement();
			Element user_element=root.addElement("user")
			.addAttribute("id", user.getId())
			.addAttribute("username", user.getUsername())
			.addAttribute("password", user.getPassword())
			.addAttribute("email",user.getEmail())
			.addAttribute("neckname", user.getNeckname())
			.addAttribute("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			
			XMLUtils.Write2Xml(document);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public User find(String username,String password) throws DocumentException, ParseException{
		Document document=XMLUtils.getDocument();
		Element element=(Element)document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
		if (element==null) {
			return null;
		}
		String id=element.attributeValue("id");
		String email=element.attributeValue("email");
		String neckname=element.attributeValue("neckname");
		String Birthday=element.attributeValue("birthday");
		Date birthday=null;
		if (Birthday==null || Birthday.trim().equals("")) {
			
		}else{
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			birthday=format.parse(Birthday);
		}
		User user=new User(id, username, password, email, neckname, birthday);
		return user;
	}
	/*
	 * 添加时，检查用户是否在数据库中存在
	 */
	public Boolean find(String username) throws DocumentException{
		Document document=XMLUtils.getDocument();
		Element element=(Element)document.selectSingleNode("//user[@username='"+username+"']");
		if (element==null) {
			return false;
		}else {
			return true;
		}
	}
}
