package com.enjoytrip.model;

public class MemberDto {
	private String user_id;
	private String user_pwd;
	private String email;
	private String name;
	private String birth;
	private String phone;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getId() {
		return user_id;
	}

	public void setId(String user_id) {
		this.user_id = user_id;
	}

	public String getPw() {
		return user_pwd;
	}

	public void setPw(String user_pwd) {
		this.user_pwd = user_pwd;
	}

}
