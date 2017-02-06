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
	//���ύȫ����String
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
	 * 1.�û�����Ϊ�գ��ұ���3-8λ��ĸ
	 * 2.���벻��Ϊ��,�ұ���3-8λ����
	 * 3.ȷ�����벻��Ϊ��,�ұ��������1һ��
	 * 4.�������䲻Ϊ�գ��ұ���Ϸ�
	 * 5.���տ�Ϊ�գ����ڲ�Ϊ��ʱ�������ǺϷ�������
	 * 6.�ǳƲ�Ϊ�գ��ұ����Ǻ���
	 * 
	 */
	public boolean validate() {
		boolean pass=true;
		//1
		if (this.username==null||this.username.trim().equals("")) {
			pass=false;
			errors.put("username", "�û�������Ϊ��!");
		}else {
			if (!((this.username).matches("[A-Za-z]{3,8}"))) {
				pass=false;
				errors.put("username", "�û�������3-8λ��ĸ!");
			}
		}
		//2
		if (this.password==null||this.password.trim().equals("")) {
			pass=false;
			errors.put("password", "���벻��Ϊ��!");
		}else {
			if (!((this.password).matches("\\d{3,8}"))) {
				pass=false;
				errors.put("password", "�������3-8λ����!");
			}
		}
		//3
		if (this.password2==null||this.password2.trim().equals("")) {
			pass=false;
			errors.put("password2", "ȷ�����벻��Ϊ��!");
		}else {
			if (!((this.password2).equals(this.password))) {
				pass=false;
				errors.put("password2", "�������벻һ��!");
			}
		}
		//4
		if (this.email==null||this.email.trim().equals("")) {
			pass=false;
			errors.put("email", "���䲻��Ϊ��!");
		}else {
			if (!((this.email).matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))) {
				pass=false;
				errors.put("email", "�����ʽ���Ϸ�!");
			}
		}
		//5
		if (this.birthday!=null&&!this.birthday.trim().equals("")) {
			/*
			 * ����У�飬SimpleDateFormat�޷�����1980-09-32�Ĵ���
			 */
			try {
				DateLocaleConverter converter=new DateLocaleConverter();
				converter.convert(this.birthday, "yyyy-MM-dd");
			} catch (Exception e) {
				pass=false;
				errors.put("birthday", "���ڸ�ʽ����ȷ");
			}
		}
		//6
		if (this.neckname==null||this.neckname.trim().equals("")) {
			pass=false;
			errors.put("neckname", "�ǳƲ���Ϊ��!");
		}else {
			if (!this.neckname.matches("^([\u4e00-\u9fa5]+)$")) {
				pass=false;
				errors.put("neckname", "�ǳƱ����Ǻ���!");
			}
		}
		return pass;
	}
}
