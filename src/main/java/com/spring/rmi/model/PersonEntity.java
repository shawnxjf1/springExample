package com.spring.rmi.model;

import java.io.Serializable;

// 创建model层，注意对象必须继承Serializable
public class PersonEntity implements Serializable {
	private int id;
	private String name;
	private int age;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}