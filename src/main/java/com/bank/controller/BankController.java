
package com.bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bank.entity.Customer;
import com.bank.entity.Login;
import com.bank.entity.PassBook;
import com.bank.service.CustomerService;
import com.bank.service.LoginService;
import com.bank.service.PassBookService;

@Controller
public class BankController {

	@Autowired
	private CustomerService bankService;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PassBookService bookService;

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
	public String deposit(@ModelAttribute Customer customer) {

		return "deposit";
	}

	@PostMapping("/deposithandler")
	public String deposithandler(@ModelAttribute PassBook passbookinfo , Model model, @ModelAttribute("Customer") Customer customer) {
		System.out.println(passbookinfo.getDeposite()+" "+ customer.getName() );
		bookService.deposite( passbookinfo.getDeposite());
		model.addAttribute("depAmount", passbookinfo.getDeposite());
		
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
	public String checkbalance(@ModelAttribute PassBook passbookinfo , Model model) {
		
		model.addAttribute("balance", passbookinfo.getBalance());
		return "checkbal";
	}
	
	@GetMapping("customerById/{customer_id}")
	public String customerDetails(@PathVariable("customer_id") int id, Model model) {
		Optional<Customer> fetchcustomerDetails = bankService.fetchcustomerDetails(id);
		model.addAttribute("fetchcustomerDetails", fetchcustomerDetails);
		
		return "Welcome";
		
	}
}
