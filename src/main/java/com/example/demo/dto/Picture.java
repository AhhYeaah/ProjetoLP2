package com.example.demo.dto;

public class Picture {
	public String large;
	public String medium;
	public String thumbnail;

	public Picture(String large, String medium, String thumbnail) {
		super();
		this.large = large;
		this.medium = medium;
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Picture [large=" + large + ", medium=" + medium + ", thumbnail=" + thumbnail + "]";
	}

}
