package com.example.demo.utils;

public class Cordinates {
	private Float latitude;
	private Float longitude;

	public Cordinates(Float latitude, Float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Cordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
