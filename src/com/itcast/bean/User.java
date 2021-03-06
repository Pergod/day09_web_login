package com.itcast.bean;

import java.util.Date;

public class User {
	private String id;
	private String username;
	private String password;
	private String email;
	private String neckname;
	private Date birthday;
	
	public User() {
	}
	public User(String id, String username, String password, String email, String neckname, Date birthday) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.neckname = neckname;
		this.birthday = birthday;
	}

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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
