package com.example.demo.initiators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Client;
import com.example.demo.dto.Location;
import com.example.demo.dto.Name;
import com.example.demo.dto.Picture;
import com.example.demo.dto.Timezone;
import com.example.demo.model.ClientModel;
import com.example.demo.repository.ClientRepository;
import com.example.demo.utils.Cordinates;

@Component
public class JSONDatabaseInitiator implements ApplicationRunner {
	@Autowired
	public ClientRepository clientRepo;

	private BufferedReader getJSONBuffer() throws IOException {
		URL urlCSV = new URL("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json");

		URLConnection urlConn = urlCSV.openConnection();

		InputStreamReader inputJSON = new InputStreamReader(((URLConnection) urlConn).getInputStream());

		return new BufferedReader(inputJSON);
	}

	private ClientModel JSONToModel(JSONObject clientJson) {

		String gender = clientJson.getString("gender");
		String phone = clientJson.getString("phone");
		String dobDate = clientJson.getJSONObject("dob").getString("date");
		String lastName = clientJson.getJSONObject("name").getString("last");
		String title = clientJson.getJSONObject("name").getString("title");
		String firstName = clientJson.getJSONObject("name").getString("first");
		String registeredDate = clientJson.getJSONObject("registered").getString("date");
		String city = clientJson.getJSONObject("location").getString("city");
		String street = clientJson.getJSONObject("location").getString("street");
		String timezoneOffset = clientJson.getJSONObject("location").getJSONObject("timezone").getString("offset");
		String timezoneDescription = clientJson.getJSONObject("location").getJSONObject("timezone")
				.getString("description");
		String postcode = Integer.toString(clientJson.getJSONObject("location").getInt("postcode"));
		String latitude = clientJson.getJSONObject("location").getJSONObject("coordinates").getString("latitude");
		String longitude = clientJson.getJSONObject("location").getJSONObject("coordinates").getString("longitude");
		String state = clientJson.getJSONObject("location").getString("state");
		String cell = clientJson.getString("cell");
		String email = clientJson.getString("email");
		String thumbnail = clientJson.getJSONObject("picture").getString("thumbnail");
		String large = clientJson.getJSONObject("picture").getString("large");
		String medium = clientJson.getJSONObject("picture").getString("medium");

		Client c = new Client(new Name(title, firstName, lastName),
				new Location(street, city, state, postcode,
						new Cordinates(Float.parseFloat(longitude), Float.parseFloat(latitude)),
						new Timezone(timezoneOffset, timezoneDescription)),
				gender, email, dobDate, registeredDate, phone, cell, new Picture(large, medium, thumbnail));

		return new ClientModel(c);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		BufferedReader buffer = getJSONBuffer();
		JSONTokener tokener = new JSONTokener(buffer);
		JSONObject json = new JSONObject(tokener);

		JSONArray resultsArray = json.getJSONArray("results");
		List<ClientModel> clientList = new ArrayList<ClientModel>();

		for (int a = 0; a < resultsArray.length(); a++) {
			clientList.add(JSONToModel(resultsArray.getJSONObject(a)));
		}
		clientRepo.saveAll(clientList);
	}
}
