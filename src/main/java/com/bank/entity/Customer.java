package com.bank.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@Column(name = "account_number")
	private String account;
	private String name;
	private String email;
	private String password;
	private String address;
	@OneToOne(mappedBy = "customer" ,cascade = CascadeType.ALL)
	private PassBook book;

	public PassBook getBook() {
		return book;
	}

	public void setBook(PassBook book) {
		this.book = book;
	}

	public String getAc() {
		return account;
	}

	public void setAc(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer(String account, String name, String email, String password, String address, PassBook book) {
		super();
		this.account = account;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.book = book;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [ac=" + account + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", book=" + book + "]";
	}

}
