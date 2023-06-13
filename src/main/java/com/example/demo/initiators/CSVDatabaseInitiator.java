package com.example.demo.initiators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
import com.opencsv.CSVReader;

@Component
public class CSVDatabaseInitiator implements ApplicationRunner {
	@Autowired
	public ClientRepository clientRepo;

	private BufferedReader getCSVBuffer() throws IOException {
		URL urlCSV = new URL("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv");

		URLConnection urlConn = urlCSV.openConnection();

		InputStreamReader inputCSV = new InputStreamReader(((URLConnection) urlConn).getInputStream());
		return new BufferedReader(inputCSV);
	}

	private ClientModel CSVToModel(String[] lista) {

		Name name = new Name(lista[1], lista[2], lista[3]);

		Cordinates cordinates = new Cordinates(Float.parseFloat(lista[8]), Float.parseFloat(lista[9]));
		Timezone timezone = new Timezone(lista[10], lista[11]);
		Location location = new Location(lista[4], lista[5], lista[6], lista[7], cordinates, timezone);
		Picture pictures = new Picture(lista[19], lista[20], lista[21]);
		Client client = new Client(name, location, lista[0], lista[12], lista[13], lista[15], lista[17], lista[18],
				pictures);

		return new ClientModel(client);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			BufferedReader buffer = getCSVBuffer();
			buffer.readLine(); // first line has csv headers

			try (CSVReader csvReader = new CSVReader(buffer)) {
				List<String[]> lista = csvReader.readAll();
				List<ClientModel> clientList = new ArrayList<ClientModel>();

				for (int contadorLinha = 0; contadorLinha < lista.size(); contadorLinha++) {
					clientList.add(CSVToModel(lista.get(contadorLinha)));
				}
				clientRepo.saveAll(clientList);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("alo");
		}
	}
}
