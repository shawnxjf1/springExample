package com.lakala.soa.examples.mybatis.model;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	private String address;
	private int age;
	private int id;
	private String name;

	// Getters and setters
	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 如果有带参数的构造器，编译器不会自动生成无参构造器。当查询需要返回对象时，ORM框架用反射来调用对象的无参构造函数，导致异常：java.lang.NoSuchMethodException:
	// 这时需要明确写出：
	public User() {
	}

	public User(int id, String address) {
		this.id = id;
		this.address = address;
	}

	public User(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public User(int id, String name, int age, String address){
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [address=" + address + ", age=" + age + ", id=" + id
				+ ", name=" + name + "]";
	}

}