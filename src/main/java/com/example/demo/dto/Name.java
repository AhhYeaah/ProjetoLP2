package com.example.demo.dto;

public class Name {
	public String title;
	public String first;
	public String last;

	public Name(String title, String firstName, String lastName) {
		this.title = title;
		this.first = firstName;
		this.last = lastName;
	}

	@Override
	public String toString() {
		return "Name [title=" + title + ", first=" + first + ", last=" + last + "]";
	}

}
