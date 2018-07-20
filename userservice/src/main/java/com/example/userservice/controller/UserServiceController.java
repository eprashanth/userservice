package com.example.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.beans.User;
import com.example.userservice.dao.UserServiceDao;

@RestController
public class UserServiceController {
	
	
	//UserServiceDao userServiceDao = new UserServiceDao();
	@Autowired
	UserServiceDao userServiceDao;
	
	@RequestMapping("/listusers")
	public List<User> getAllUsers(){
		return userServiceDao.getAllUsers();
	}
	
	@RequestMapping("/save")
	public String saveUser(User user){
		return userServiceDao.saveUser(user);
		
		
	}

}
