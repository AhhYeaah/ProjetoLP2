package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Enums.ClientTypeEnum;
import com.example.demo.Enums.Gender;
import com.example.demo.Enums.Region;
import com.example.demo.dto.Client;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ClientModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Enumerated(EnumType.STRING)
	private ClientTypeEnum type;

	private String title;
	private String first;
	private String last;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private Region region;

	private String street;
	private String city;
	private String state;
	private String postcode;

	@Column(name = "timezoneOffset")
	private String offset;
	@Column(name = "timezoneDescription")
	private String description;

	private String large;
	private String thumbnail;
	private String medium;

	private Float longitude;
	private Float latitude;

	@ElementCollection
	private List<String> mobilePhones;

	@ElementCollection
	private List<String> telephonePhones;

	private String email;

	private LocalDateTime birthday;
	private LocalDateTime registered;

	private String nationality = "BR";

	public ClientModel() {
	}

	public ClientModel(Client client) {
		this.type = client.type;
		this.title = client.name.title;
		this.first = client.name.first;
		this.last = client.name.last;
		this.gender = client.gender;
		this.region = client.location.region;
		this.street = client.location.street;
		this.city = client.location.city;
		this.state = client.location.state;
		this.postcode = client.location.postcode;
		this.longitude = client.location.cordinates.getLongitude();
		this.latitude = client.location.cordinates.getLatitude();
		this.mobilePhones = new ArrayList<>(client.mobileNumbers);
		this.telephonePhones = new ArrayList<>(client.telephoneNumbers);
		this.email = client.email;
		this.birthday = client.birthday;
		this.registered = client.registered;
		this.nationality = client.nationality;

		this.large = client.pictures.large;
		this.medium = client.pictures.medium;
		this.thumbnail = client.pictures.thumbnail;

		this.offset = client.location.timezone.offset;
		this.description = client.location.timezone.description;
	}
}
