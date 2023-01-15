package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerRepository.CustomerRepo;
import com.example.demo.entities.Customer;
import com.example.demo.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<Customer> createCustomerRest(@RequestBody Customer customer) {

		Customer customerResponse = customerServiceImpl.createCustomer(customer);
		System.out.println(customer.toString());
		System.out.println("Customer created successfully......");
		return new ResponseEntity<Customer>(customerResponse, HttpStatus.CREATED);
	}

	@GetMapping("getSingleCustomer/{id}")
	public ResponseEntity<Customer> getSingleCustomerRest(@PathVariable int  id) {
		Customer customerResponse=customerServiceImpl.getSingleCustomer(id);
		return new ResponseEntity<Customer>(customerResponse,HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAllCustomerRest() {
		List<Customer> customerResponseList = customerServiceImpl.fetchingCustomer();
		return new ResponseEntity<List<Customer>>(customerResponseList, HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<List<Customer>> deleteCustomerRest(@PathVariable int id) {
		customerServiceImpl.deleteCustomer(id);
		List<Customer> response = customerServiceImpl.fetchingCustomer();

		return new ResponseEntity<List<Customer>>(response, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Customer> updateCustomerRest(@RequestBody Customer customer, @PathVariable int id) {
		Customer customeresponse = customerServiceImpl.updateCustomer(customer, id);
		return new ResponseEntity<Customer>(customeresponse, HttpStatus.OK);
	}
}
