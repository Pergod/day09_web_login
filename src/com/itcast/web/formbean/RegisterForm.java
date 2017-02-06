package com.itcast.web.formbean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	private String id;
	private String username;
	private String password;
	private String password2;
	private String email;
	private String neckname;
	//表单提交全都是String
	private String birthday;
	private String checkcode;
	private Map<String, String> errors= new HashMap<String,String>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNeckname() {
		return neckname;
	}
	public void setNeckname(String neckname) {
		this.neckname = neckname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	/*
	 * 1.用户名不为空，且必须3-8位字母
	 * 2.密码不能为空,且必须3-8位数字
	 * 3.确认密码不能为空,且必须和密码1一致
	 * 4.电子邮箱不为空，且必须合法
	 * 5.生日可为空，但在不为空时，必须是合法的日期
	 * 6.昵称不为空，且必须是汉字
	 * 
	 */
	public boolean validate() {
		boolean pass=true;
		//1
		if (this.username==null||this.username.trim().equals("")) {
			pass=false;
			errors.put("username", "用户名不能为空!");
		}else {
			if (!((this.username).matches("[A-Za-z]{3,8}"))) {
				pass=false;
				errors.put("username", "用户名必须3-8位字母!");
			}
		}
		//2
		if (this.password==null||this.password.trim().equals("")) {
			pass=false;
			errors.put("password", "密码不能为空!");
		}else {
			if (!((this.password).matches("\\d{3,8}"))) {
				pass=false;
				errors.put("password", "密码必须3-8位数字!");
			}
		}
		//3
		if (this.password2==null||this.password2.trim().equals("")) {
			pass=false;
			errors.put("password2", "确认密码不能为空!");
		}else {
			if (!((this.password2).equals(this.password))) {
				pass=false;
				errors.put("password2", "两次密码不一致!");
			}
		}
		//4
		if (this.email==null||this.email.trim().equals("")) {
			pass=false;
			errors.put("email", "邮箱不能为空!");
		}else {
			if (!((this.email).matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))) {
				pass=false;
				errors.put("email", "邮箱格式不合法!");
			}
		}
		//5
		if (this.birthday!=null&&!this.birthday.trim().equals("")) {
			/*
			 * 日期校验，SimpleDateFormat无法处理1980-09-32的错误
			 */
			try {
				DateLocaleConverter converter=new DateLocaleConverter();
				converter.convert(this.birthday, "yyyy-MM-dd");
			} catch (Exception e) {
				pass=false;
				errors.put("birthday", "日期格式不正确");
			}
		}
		//6
		if (this.neckname==null||this.neckname.trim().equals("")) {
			pass=false;
			errors.put("neckname", "昵称不能为空!");
		}else {
			if (!this.neckname.matches("^([\u4e00-\u9fa5]+)$")) {
				pass=false;
				errors.put("neckname", "昵称必须是汉字!");
			}
		}
		return pass;
	}
}
