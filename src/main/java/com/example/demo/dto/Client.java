package com.example.demo.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import com.example.demo.BoundingBoxes.ClientType;
import com.example.demo.Enums.ClientTypeEnum;
import com.example.demo.Enums.Gender;
import com.example.demo.model.ClientModel;
import com.example.demo.utils.Cordinates;

public class Client {
	public ClientTypeEnum type;

	public Name name;
	public Gender gender;

	public Location location;
	public String email;

	public LocalDateTime birthday;
	public LocalDateTime registered;

	public ArrayList<String> telephoneNumbers = new ArrayList<String>();
	public ArrayList<String> mobileNumbers = new ArrayList<String>();;

	public Picture pictures;

	public String nationality = "BR";

	public Client(ClientModel clientModel) {
		this.type = clientModel.getType();
		this.name = new Name(clientModel.getTitle(), clientModel.getFirst(), clientModel.getLast());
		this.gender = clientModel.getGender();
		this.location = new Location(clientModel.getStreet(), clientModel.getCity(), clientModel.getState(),
				clientModel.getPostcode(), new Cordinates(clientModel.getLongitude(), clientModel.getLatitude()),
				new Timezone(clientModel.getOffset(), clientModel.getDescription()));

		this.email = clientModel.getEmail();
		this.birthday = clientModel.getBirthday();
		this.registered = clientModel.getRegistered();

		this.telephoneNumbers = new ArrayList<>(clientModel.getTelephonePhones());
		this.mobileNumbers = new ArrayList<>(clientModel.getMobilePhones());

		this.pictures = new Picture(clientModel.getLarge(), clientModel.getMedium(), clientModel.getThumbnail()); // available
		this.nationality = clientModel.getNationality();
	}

	public Client(Name name, Location location, String gender, String email, String birthday, String registered,
			String telephoneNumbers, String mobileNumbers, Picture pictures) {
		super();

		this.name = name;
		this.email = email;

		this.birthday = LocalDateTime.ofInstant(Instant.parse(birthday), ZoneOffset.UTC);
		this.registered = LocalDateTime.ofInstant(Instant.parse(registered), ZoneOffset.UTC);
		this.type = ClientType.getClientType(location.cordinates);

		this.location = location;

		this.telephoneNumbers.add(getFormatedPhoneNumber(telephoneNumbers));
		this.mobileNumbers.add(getFormatedPhoneNumber(mobileNumbers));

		this.gender = pickGenderLetter(gender);

		this.pictures = pictures;
	}

	private Gender pickGenderLetter(String gender) {
		if (gender.equals("male")) {
			return Gender.M;
		} else {
			return Gender.F;
		}
	}

	private String getFormatedPhoneNumber(String phoneNumber) {
		return "+55" + phoneNumber.replaceAll("\\D+", "");
	}

	@Override
	public String toString() {
		return "Client [type=" + type + ", name=" + name + ", gender=" + gender + ", location=" + location + ", email="
				+ email + ", birthday=" + birthday + ", registered=" + registered + ", telephoneNumbers="
				+ telephoneNumbers + ", mobileNumbers=" + mobileNumbers + ", pictures=" + pictures + ", nationality="
				+ nationality + "]";
	}

}
