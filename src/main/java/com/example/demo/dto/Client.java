package com.example.demo.dto;

import java.util.ArrayList;

import com.example.demo.BoundingBoxes.ClientType;
import com.example.demo.Enums.ClientTypeEnum;

public class Client {
	public ClientTypeEnum type;

	public Name name;
	public char gender;

	public Location location;
	public String email;
	public String birthday;
	public String registered;

	public ArrayList<String> telephoneNumbers = new ArrayList<String>();
	public ArrayList<String> mobileNumbers = new ArrayList<String>();;

	public Picture pictures;

	public String nationality = "BR";

	private char pickGenderLetter(String gender) {
		// bruh, == doesnt work on strings
		// stupid language.
		if (gender.equals("male")) {
			return 'm';
		} else {
			return 'f';
		}
	}

	private String getFormatedPhoneNumber(String phoneNumber) {
		return "+55" + phoneNumber.replaceAll("\\D+", "");
	}

	public Client(Name name, Location location, String gender, String email, String birthday, String registered,
			String telephoneNumbers, String mobileNumbers, Picture pictures) {
		super();

		this.name = name;
		this.email = email;

		this.birthday = birthday;
		this.registered = registered;
		this.type = ClientType.getClientType(location.cordinates);

		this.location = location;

		this.telephoneNumbers.add(getFormatedPhoneNumber(telephoneNumbers));
		this.mobileNumbers.add(getFormatedPhoneNumber(mobileNumbers));

		this.gender = pickGenderLetter(gender);

		this.pictures = pictures;
	}

	@Override
	public String toString() {
		return "Client [type=" + type + ", name=" + name + ", gender=" + gender + ", location=" + location + ", email="
				+ email + ", birthday=" + birthday + ", registered=" + registered + ", telephoneNumbers="
				+ telephoneNumbers + ", mobileNumbers=" + mobileNumbers + ", pictures=" + pictures + ", nationality="
				+ nationality + "]";
	}

}
