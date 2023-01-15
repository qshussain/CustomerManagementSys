package com.example.demo.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public List<Customer> fetchingCustomer();
	public Customer getSingleCustomer(int  id);
	public void  deleteCustomer(int id);
	public Customer updateCustomer(Customer customer,int id);

}
