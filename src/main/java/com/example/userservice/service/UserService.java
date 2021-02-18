package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.vo.Department;
import com.example.userservice.vo.ResponseTemplateVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	public User saveDepartment(User department)
	{
		log.info("Save User called from Service");
		return userRepository.save(department);
	}
	
	public User findUserById(Long userId)
	{
		log.info("findUserById called from Service");
		return userRepository.findByUserId(userId);
	}
	
	public ResponseTemplateVO getUserWithDepartment(Long userId)
	{
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		User user = userRepository.findByUserId(userId);
		
		String url = "http://localhost:8082/department/" + user.getDepartmentId();
		System.out.println("URL : " + url);
				
		Department department = restTemplate.getForObject(url,Department.class);
		System.out.println("RESPONSE " + department);
		
  		vo.setUser(user);
		vo.setDepartment(department);
				
		return vo;
	
	}
}
