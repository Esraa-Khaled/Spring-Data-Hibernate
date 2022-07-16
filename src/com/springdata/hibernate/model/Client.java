package com.springdata.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="client")
public class Client {
	
	// GeneratedValue strategy diffrentiate from each database type
	// AUTO(default) >> will let hibernate take the best descision according to DB type
	// IDENTITY >> will increment the last id
	// SEQUANCE >> hibernate will take next id value from generated sequence
	// TABLE >> hibernate will create table and fetch next id from it
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //for Auto Increment
	@Column(name="client_id")
	private Long id;
	
	@Column(name="client_user_name") // can be added on getter method
	private String userName;
	
	@Column(name="client_full_name")
	private String fullName;
	
	@Column(name="client_age")
	private int age;
	
	@Column(name="client_email")
	private String email;

	// default TemporalType.TIMESTAMP, TemporalType.DATE , TemporalType.TIME
	@Temporal(TemporalType.DATE) // will save column as date only
	@Column(name="joined_date")
	private Date joinedDate;
	
	// using @Lob >> hibernate will decide if its Clob or BLob based on type of variable
	// String >>(CLOB) or byte[] (BLOB)
	@Lob() // for large objects  CLOB, BLOB
	private String description;
	
	@Transient // tell hibernate to escape this column
	private String sharedInfo;
	
	public Client() {}
	
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

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSharedInfo() {
		return sharedInfo;
	}

	public void setSharedInfo(String sharedInfo) {
		this.sharedInfo = sharedInfo;
	}
	
}
