package com.person.reflection;

public class UserImpl implements IUser {
	String name;

	public UserImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
