package com.bank.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PassBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long passBookId;
	private int deposite;
	private int withdraw;
	private double balance;
	private Date date;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="account_number")
	private Customer customer;

	public PassBook(long passBookId, int deposite, int withdraw, double balance, Date date, Customer customer) {
		super();
		this.passBookId = passBookId;
		this.deposite = deposite;
		this.withdraw = withdraw;
		this.balance = balance;
		this.date = date;
		this.customer = customer;
	}

	public PassBook(Customer customer) {
		super();
		this.customer = customer;
	}

	public long getPassBookId() {
		return passBookId;
	}

	public void setPassBookId(long passBookId) {
		this.passBookId = passBookId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PassBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDeposite() {
		return deposite;
	}

	public void setDeposite(int deposite) {
		this.deposite = deposite;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PassBook [deposite=" + deposite + ", withdraw=" + withdraw + ", balance=" + balance + ", date=" + date
				+ "]";
	}

}
