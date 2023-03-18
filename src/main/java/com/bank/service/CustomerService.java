package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.CustomerRepository;
import com.bank.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository bankRepository;

	public Customer addCustomer(Customer customer) {
		this.bankRepository.save(customer);
		return customer;

	}

	public boolean loginUser(String email, String password) {
		Customer findByEmail = bankRepository.findByEmail(email);
		if (findByEmail != null && findByEmail.getPassword().equals(password)) {
			return true;
		}
		return false;

	}

}
