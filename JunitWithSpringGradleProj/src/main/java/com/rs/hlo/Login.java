package com.rs.hlo;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name="USERS")
@NamedNativeQuery(name="AUTHENTICATE_QUERY",
				  query="{call P_LOGIN_CHECK(?,?,?)}",
				  callable=true)
public class Login {
	private String username;
	private String password;
	
	
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
}