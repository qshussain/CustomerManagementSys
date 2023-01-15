package com.example.demo.customerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>,CrudRepository<Customer, Integer>{

//	
//	public Customer findByCustFirstName(String firstname);
//	
//	public Customer deleteBycustId(int id);

}
