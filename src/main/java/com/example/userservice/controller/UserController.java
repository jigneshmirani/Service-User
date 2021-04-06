package com.example.userservice.controller;


import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.ResponseTemplateVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

	@GetMapping("/")
	public String getSampleData()
	{
		log.info("Sample data method");
		return "Welcome to jenkins world -- version 1.36"; 
	}
	
	@PostMapping("/saveData")
	public User saveDepartment(@RequestBody User user)
	{
		log.info("Save User called from controller");
		return userService.saveDepartment(user);
	}
	
	//@GetMapping("/{id}")
	//public User findUserById(@PathVariable("id") Long userId)
	//{
		//log.info("findUserById called from Controller");
		//return userService.findUserById(userId);
	//}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId)
	{
		return userService.getUserWithDepartment(userId);
	}
	
	@GetMapping("/getName/{name}")
	public String getUserName(@PathVariable("name") String userName)
	{
		log.info("Show Name from controller");
		return userName;
	}

	@GetMapping("/getData/{name}")
	public String getData(@PathVariable("name") String userName)
	{
		log.info("Show Name from controller");
		return userName;
	}
}


