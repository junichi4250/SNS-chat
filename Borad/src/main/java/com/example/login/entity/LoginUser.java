package com.example.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ログインユーザーのユーザー名、パスワードを格納するためのEntity
 * @author jun
 *
 */
@Entity
@Table(name = "user")
public class LoginUser {
//
//	@Column(name = "user_id")
//	@Id
//	private Long userId;

	@Column(name = "username")
	@Id
	private String userName;

	@Column(name = "password")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
