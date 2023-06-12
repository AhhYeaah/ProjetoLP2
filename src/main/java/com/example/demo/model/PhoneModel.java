package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhoneModel {
	@Id()
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;

	String mobileNumber;
	String phoneNumber;
}