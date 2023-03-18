
package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bank.entity.Customer;
import com.bank.entity.Login;
import com.bank.service.CustomerService;
import com.bank.service.LoginService;

@Controller
public class BankController {

	@Autowired
	private CustomerService bankService;

	@Autowired
	private LoginService loginService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signuphandler")
	public String signuphandler(@ModelAttribute("Customer") Customer customer, Model m) {
		m.addAttribute("customer", customer);
		System.out.println(customer);
		this.bankService.addCustomer(customer);
		return "signuphandler";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("Login") Login login) {
//		this.loginService.addLogin(login);
		return "login";
	}

//	@PostMapping("/loginhandler")
//	public ModelAndView loginhandler(@ModelAttribute("Customer") Customer customer,
//			@ModelAttribute("Login") Login login, Model m) {
//		m.addAttribute("customer", customer);
//		ModelAndView mv = new ModelAndView();
//		if (customer.getEmail().equalsIgnoreCase("alfaaz@gmail.com")
//				|| customer.getPassword().equalsIgnoreCase("123456")) {
//			mv.setViewName("loginhandler");
//		} else {
//			mv.setViewName("error");
//		}
//		return mv;
//	}

//	New Loginhandler code
	@PostMapping("/loginhandler")
	public String loginhandler(@ModelAttribute("Customer") Customer customer, @ModelAttribute("Login") Login login,
			Model m) {
		m.addAttribute("customer", customer);
		boolean loginUser = bankService.loginUser(customer.getEmail(), customer.getPassword());
		if(loginUser== true) {
			return "loginhandler";
		}
		return "error";
	}

	
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit";
	}

	@GetMapping("/deposithandler")
	public String deposithandler() {
		return "deposithandler";
	}

	@GetMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}

	@GetMapping("/withdrawhandler")
	public String withdrawhandler() {
		return "withdrawhandler";
	}

	@GetMapping("/checkbal")
	public String checkbalance() {
		return "checkbal";
	}
}
