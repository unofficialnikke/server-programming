package com.example.friendList.domain;

public class Friend {
	private String name;

	public Friend() {}
	
	public Friend(String name) {
		super();
		this.name = name;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Message [name=" + name + "]";
	}
}