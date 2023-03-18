package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.LoginRepository;
import com.bank.entity.Login;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public Login addLogin(Login login) {
		this.loginRepository.save(login);
		return login;	
	}
}
