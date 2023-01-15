package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.customerRepository.UserRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.serviceInterface.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User userRes = userRepository.save(user);
		if (userRes.equals(null)) {
			throw new UsernameNotFoundException("USER NOT FOUND");
		}

		return userRes;
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAllUser = userRepository.findAll();
		if (findAllUser.equals(null)) {
			throw new UsernameNotFoundException("USERS NOT FOUND FROM DATABASE");
		}
		return findAllUser;
	}

	@Override
	public User getSingleUser(int id) {
		User findByuser_id = userRepository.findByUserid(id);
		if (findByuser_id.equals(id)) {
			throw new UsernameNotFoundException("USER NOT FOUND WITH THIS ID = " + id);
		}

		return findByuser_id;
	}

	@Override
	public void deleteById(int id) {

		boolean existsById = userRepository.existsById(id);
		if (!existsById) {
			throw new UserNotFoundException("USER NOT FOUND WITH THIS ID +" + id);

		}
		userRepository.findAll();
	}

	@Override
	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public User updateUser(User user, int id) {
//	 Optional<User> updatedUser  = userRepository.findById(id);
//	 
//	 updatedUser.stream().map(b -> {
//			if (b.getUse == id) {
//
//				b.setCustEmail(customer.getCustEmail());
//				b.setCustFirstName(customer.getCustFirstName());
//				b.setCustId(customer.getCustId());
//				b.setCustLastName(customer.getCustLastName());
//				b.setCustMiddleName(customer.getCustMiddleName());
//				b.setCustName(customer.getCustName());
//
//			}
//
//			return b;
//		return null;
//	}

}
