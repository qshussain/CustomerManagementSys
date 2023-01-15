package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customerRepository.CustomerRepo;
import com.example.demo.entities.Customer;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.serviceInterface.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> fetchingCustomer() {

		return customerRepo.findAll();
	}



	@Override
	public Customer updateCustomer(Customer customer, int id) {
		Optional<Customer> updatedCustomer = customerRepo.findById(id);
		updatedCustomer.stream().map(b -> {
			if (b.getCustId() == id) {

				b.setCustEmail(customer.getCustEmail());
				b.setCustFirstName(customer.getCustFirstName());
				b.setCustId(customer.getCustId());
				b.setCustLastName(customer.getCustLastName());
				b.setCustMiddleName(customer.getCustMiddleName());
				b.setCustName(customer.getCustName());

			}

			return b;
		}).collect(Collectors.toList());
		customerRepo.save(customer);
		return customer;

	}

	@Override
	public Customer getSingleCustomer(int id) {
		Customer resp = this.customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CUSTOMER NOT FOUND WITH THIS ID = " + id));

		return resp;
	}
//
//	@Override
//	public Customer deleteCustomer(int id) {
//		boolean existId = customerRepo.existsById(id);
//		if (!existId) {
//			throw new ResourceNotFoundException("CUSTOMER NOT FOUND WITH THIS ID = " + id);
//		}
//		return customerRepo.deleteBycustId(id);
//	}

	@Override
	public void deleteCustomer(int id) {

		boolean existsById = customerRepo.existsById(id);
		if (!existsById) {
			throw new ResourceNotFoundException("CUSTOMER NOT FOUND WITH THIS ID = " + id);
		}
		customerRepo.deleteById(id);

	}
}
