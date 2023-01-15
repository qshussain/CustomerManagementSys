package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.User;
import com.example.demo.serviceImpl.UserServiceImpl;
import com.example.demo.serviceInterface.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<User> createUserRest(@RequestBody User user) {

		User userResp = userServiceImpl.createUser(user);
		System.out.println(user.toString());
		System.out.println("User created successfully......");
		return new ResponseEntity<User>(userResp, HttpStatus.CREATED);
	}

	@GetMapping("getSingleUser/{id}")
	public ResponseEntity<User> getSingleUserRest(@PathVariable int id) {
		User userResponse = userServiceImpl.getSingleUser(id);
		return new ResponseEntity<User>(userResponse, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUserRest() {
		List<User> userResponseList = userServiceImpl.getAllUser();
		return new ResponseEntity<List<User>>(userResponseList, HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<List<User>> deleteUSerRest(@PathVariable int id) {
		userServiceImpl.deleteById(id);
		List<User> response = userServiceImpl.getAllUser();

		return new ResponseEntity<List<User>>(response, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<User> updateUserRest(@RequestBody User user, @PathVariable int id) {
		User userResponse = userServiceImpl.updateUser(user, id);
		return new ResponseEntity<User>(userResponse, HttpStatus.OK);
	}
}
