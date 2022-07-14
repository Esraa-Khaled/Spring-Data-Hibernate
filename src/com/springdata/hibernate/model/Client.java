package com.springdata.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="client_id")
	private Long id;
	
	@Column(name="client_user_name")
	private String userName;
	
	@Column(name="client_full_name")
	private String fullName;
	
	@Column(name="client_age")
	private int age;
	
	@Column(name="client_email")
	private String email;

	
	public Client(String userName, String fullName, int age, String email) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.age = age;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
