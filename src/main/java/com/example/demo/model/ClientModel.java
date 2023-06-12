package com.example.demo.model;

import java.sql.Date;
import java.util.ArrayList;

import com.example.demo.Enums.ClientTypeEnum;
import com.example.demo.Enums.Gender;
import com.example.demo.Enums.Region;
import com.example.demo.dto.Picture;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

	public String email;

	public Date birthday;
	public Date registered;

	public ArrayList<String> telephoneNumbers = new ArrayList<String>();
	public ArrayList<String> mobileNumbers = new ArrayList<String>();;

	public Picture pictures;

	public String nationality = "BR";

}
