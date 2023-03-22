package com.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.CustomerRepository;
import com.bank.dao.PassBookRepository;
import com.bank.entity.Customer;
import com.bank.entity.PassBook;

@Service
public class PassBookService {

	@Autowired
	private PassBookRepository bookRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	public void deposite(int deposite) {
		bookRepository.save(deposite);
	}
	
	public Optional<Customer> findAccount(String account) {
		Optional<Customer> opational= customerRepository.findByAccount(account);
		return opational;
		
	}

	public Optional<PassBook> findByAcc(String account) {
	Optional<PassBook> findByCustomerAccountNumber = bookRepository.findByCustomerAccountNumber(account);
	return findByCustomerAccountNumber;
		
	}


}
