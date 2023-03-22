package com.bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.bank.dao.CustomerRepository;
import com.bank.dao.PassBookRepository;
import com.bank.entity.Customer;
import com.bank.entity.PassBook;
import com.bank.service.CustomerService;
import com.bank.service.PassBookService;

@Controller
public class MoneyTransaction {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PassBookService passBookService;

	@Autowired
	private PassBookRepository bookRepository;

	@GetMapping("/money-transfer")
	public String transfer() {
		return "moneytransfer";

	}

	@PostMapping("/money-transfer-handler")
	public String moneytransferhandler(@RequestParam("account") String account,
			@RequestParam("balance") double amount) {
		System.out.println(account + " " + amount);
		Optional<Customer> customerAccount = passBookService.findAccount(account);
		Optional<PassBook> passbookAccount = passBookService.findByAcc(account);
		if (customerAccount.isPresent()) {
			if (passbookAccount.isPresent()) {
				PassBook passBook = passbookAccount.get();
				passBook.setBalance(passBook.getBalance() + amount);
				bookRepository.save(passBook);
			} else {

				Customer customer = customerAccount.get();
				PassBook book = new PassBook(customer);
				book.setBalance(book.getBalance() + amount);
				bookRepository.save(book);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account does not exist");
		}
		return "welcome";

	}

	@GetMapping("/testing/{account-number}")
	public String findbyAc(@PathVariable("account-number") String account) {
		passBookService.findByAcc(account);
		System.out.println(account);
		return "welcome";

	}

}
