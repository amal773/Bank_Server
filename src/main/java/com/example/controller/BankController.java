package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;
import com.example.model.Login;
import com.example.model.Password;
import com.example.model.Receiver;
import com.example.model.Admin;
import com.example.model.Amount;

@Controller
public class BankController {

	@Autowired
	RestTemplate rs;

	@PostMapping("admin/login")
	public ModelAndView adminLogin(@RequestBody Login login) {
		
		
		ModelAndView mv = new ModelAndView("samsung.html");
		ResponseEntity<Admin> admin = rs.postForEntity("http://ADMIN/login", login, Admin.class);
		Admin cust = admin.getBody();
		mv.addObject("customer", cust);

		return mv;
	}

	@GetMapping("/admin/getallcustomers")
	public ModelAndView getallcustomers() {
		ModelAndView mv = new ModelAndView("getallcustomers.html");

		ResponseEntity<Customer[]> response = rs.getForEntity("http://ADMIN/getallcustomers",
				Customer[].class);
		Customer[] customers = response.getBody();
		mv.addObject("customer", customers);

		return mv;
	}

	@GetMapping("/admin/getonecustomer/{id}")
	public ModelAndView getonecustomer(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("samsung.html");

		Customer cust = rs.getForObject("http://ADMIN/getonecustomer/" + id, Customer.class);
		mv.addObject("customer", cust);

		return mv;
	}

	@PutMapping("/admin/updatecustomer/{id}")
	public ModelAndView addCustomer(@PathVariable int id, @RequestBody Customer customer) {
		ModelAndView mv = new ModelAndView("samsung.html");

		rs.put("http://ADMIN/updatecustomer/" + id, customer);
		String cust = "Customer updated successfully";
		mv.addObject("customer", cust);
		
		return mv;
	}
	
	@GetMapping("/user/login")
	public ModelAndView customerLoginEntry() {
		ModelAndView mv = new ModelAndView("customerlogin.html");
//		ResponseEntity<Customer> customer = rs.postForEntity("http://CUSTOMER/login", login, Customer.class);
//		Customer cust = customer.getBody();
//		mv.addObject("customer", cust);

		return mv;
	}
	
	@PostMapping("/user/login")
	public ModelAndView customerLogin(@RequestBody Login login) {
		ModelAndView mv = new ModelAndView("customerlogin.html");
		ResponseEntity<Customer> customer = rs.postForEntity("http://CUSTOMER/login", login, Customer.class);
		Customer cust = customer.getBody();
		mv.addObject("customer", cust);

		return mv;
	}
	
	@PutMapping("/user/deposit/{id}")
	public ModelAndView depositCheck(@PathVariable int id, @RequestBody Amount amt) {
		
		ModelAndView mv = new ModelAndView("samsung.html");

		rs.put("http://CUSTOMER/deposit/" + id, amt);
		String cust = "Amount deposited successfully";
		mv.addObject("customer", cust);
		
		return mv;
	}
	
	@GetMapping("/user/deposit/")
	public ModelAndView depositCheckEntry(@RequestBody Amount amt) {
		ModelAndView mv = new ModelAndView("customerlogin.html");
//		ResponseEntity<Customer> customer = rs.postForEntity("http://CUSTOMER/login", login, Customer.class);
//		Customer cust = customer.getBody();
		mv.addObject("amt", amt);

		return mv;
	}
	
	@PutMapping("/user/withdrawal/{id}")
	public ModelAndView withdrawalCheck(@PathVariable int id, @RequestBody Amount amt) {
		
		ModelAndView mv = new ModelAndView("samsung.html");

		rs.put("http://CUSTOMER/withdrawal/" + id, amt);
		String cust = "Amount withdrawn successfully";
		mv.addObject("customer", cust);
		
		return mv;
	}
	
	@GetMapping("/user/checkbalance/{id}")
	public ModelAndView checkBalance(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("samsung.html");
		Float bal = rs.getForObject("http://CUSTOMER/checkbalance/" + id, Float.class);
		String cust = "Your balance is "+bal+" rupees";
		mv.addObject("customer", cust);
		return mv;
	}
	
	@PutMapping("/user/changepassword/{id}")
	public ModelAndView changePassword(@PathVariable int id, @RequestBody Password pass) {
		ModelAndView mv = new ModelAndView("samsung.html");

		rs.put("http://CUSTOMER/changepassword/" + id, pass);
		String cust = "Your password changed successfully";
		mv.addObject("customer", cust);
		
		return mv;
	}
	
	@PutMapping("/user/updatecustomer/{id}")
	public ModelAndView updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		ModelAndView mv = new ModelAndView("samsung.html");

		rs.put("http://CUSTOMER/updatecustomer/" + id, customer);
		String cust = "Your details updated successfully";
		mv.addObject("customer", cust);
		
		return mv;
	}
	
	@PutMapping("/user/transfer/{id}")
	public ModelAndView transact(@PathVariable int id, @RequestBody Receiver rec) {
		ModelAndView mv = new ModelAndView("samsung.html");

		rs.put("http://CUSTOMER/transfer/" + id, rec);
		String cust = "Transaction done successfully";
		mv.addObject("customer", cust);
		
		return mv;
	}



}
