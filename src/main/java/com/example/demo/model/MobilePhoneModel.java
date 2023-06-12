package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class MobilePhoneModel {

	@Id()
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;

}
