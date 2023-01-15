package com.example.demo.serviceInterface;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	
	public User createUser(User user);
	public List<User>getAllUser();
	public User getSingleUser(int id);
	public void deleteById(int id);
	public User updateUser(User user,int id);

}
