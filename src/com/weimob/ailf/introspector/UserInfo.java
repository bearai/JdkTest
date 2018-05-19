package com.weimob.ailf.introspector;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月13日   下午1:53:51
 * @version 1.0
 **/
public class UserInfo {
	
	private Long id;
	
	private String name;
	
	private int age;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
