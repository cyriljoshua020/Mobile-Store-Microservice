package com.abc.jwtsecurity.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO {

	private String usernameOrEmail;
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
}
