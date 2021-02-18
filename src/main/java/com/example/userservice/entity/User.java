package com.example.userservice.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
    @GeneratedValue
    private Long userId;
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId, String name, Long departmentId) {
		super();
		this.userId = userId;
		this.name = name;
		this.departmentId = departmentId;
	}
	private String name;
    private  Long departmentId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
}
