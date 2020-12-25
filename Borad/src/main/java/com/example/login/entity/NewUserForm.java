package com.example.login.entity;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NewUserForm implements Serializable{

	@NotEmpty(message = "名前を入力してください")
	@Size(max = 50, message = "名前は50桁以内で入力してください")
	private String userName;

	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
