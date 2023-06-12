package com.example.demo.dto;

import com.example.demo.Enums.Region;
import com.example.demo.utils.Cordinates;
import com.example.demo.utils.EstadoRegiao;

public class Location {
	public Region region;
	public String street;
	public String city;
	public String state;
	public String postcode;
	public Cordinates cordinates;
	public Timezone timezone;

	public Location(String street, String city, String state, String postcode, Cordinates cordinates,
			Timezone timezone) {
		super();
		this.region = EstadoRegiao.getRegionByState(state);

		this.street = street;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.cordinates = cordinates;
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		return "Location [region=" + region + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", postcode=" + postcode + ", cordinates=" + cordinates + ", timezone=" + timezone + "]";
	}

}
