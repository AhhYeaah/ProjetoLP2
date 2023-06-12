package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Client;
import com.example.demo.dto.Location;
import com.example.demo.dto.Name;
import com.example.demo.dto.Picture;
import com.example.demo.dto.Timezone;
import com.example.demo.repository.ClientRepository;
import com.example.demo.utils.Cordinates;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RestController
@RequestMapping("/helloWorld")
public class TesteControler {

	@Autowired
	private ClientRepository clientRepository;

	private Client CSVToModel(String[] lista) {

		Name name = new Name(lista[1], lista[2], lista[3]);

		Cordinates cordinates = new Cordinates(Float.parseFloat(lista[8]), Float.parseFloat(lista[9]));
		Timezone timezone = new Timezone(lista[10], lista[11]);
		Location location = new Location(lista[4], lista[5], lista[6], lista[7], cordinates, timezone);
		Picture pictures = new Picture(lista[19], lista[20], lista[21]);
		Client client = new Client(name, location, lista[0], lista[12], lista[13], lista[15], lista[17], lista[18],
				pictures);

		return client;
	}

	@GetMapping
	public List<Client> falaOlaMundo() throws IOException, CsvException {
		try {
			URL urlCSV = new URL("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv");

			URLConnection urlConn = urlCSV.openConnection();

			InputStreamReader inputCSV = new InputStreamReader(((URLConnection) urlConn).getInputStream());
			BufferedReader br = new BufferedReader(inputCSV);

			br.readLine();

			try (CSVReader csvReader = new CSVReader(br)) {
				List<String[]> lista = csvReader.readAll();
				List<Client> clientList = new ArrayList<Client>();

				for (int contadorLinha = 0; contadorLinha < lista.size(); contadorLinha++) {
					clientList.add(CSVToModel(lista.get(contadorLinha)));
				}
				return clientList;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("alo");
		}
		return null;
	}

}
