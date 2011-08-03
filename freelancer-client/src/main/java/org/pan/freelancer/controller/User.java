package org.pan.freelancer.controller;

public class User {
	
	private Integer id;
	
	private String name;
	
	private String emailAddress;
	
	private String phone;

	public User(Integer id, String name, String emailAddress, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}