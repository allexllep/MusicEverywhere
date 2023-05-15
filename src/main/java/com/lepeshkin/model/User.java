package com.lepeshkin.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(nullable = false, unique = true)
	private String login;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String userPassword;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Collection> collectionList;
	
	public User() {
		super();
	}

	public User(long userId, String login, String email, String userPassword) {
		super();
		this.userId = userId;
		this.login = login;
		this.email = email;
		this.userPassword = userPassword;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}
	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
		
	}

	public String getUserPassword() {
		return userPassword;
	}

	public User setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		return this;
	}

}
