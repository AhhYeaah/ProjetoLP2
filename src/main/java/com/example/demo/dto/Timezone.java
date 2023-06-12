package com.example.demo.dto;

public class Timezone {
	public String offset;
	public String description;

	public Timezone(String offset, String description) {
		super();
		this.offset = offset;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Timezone [offset=" + offset + ", description=" + description + "]";
	}

}
