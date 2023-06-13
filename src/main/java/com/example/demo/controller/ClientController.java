package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enums.ClientTypeEnum;
import com.example.demo.Enums.Region;
import com.example.demo.dto.Pagination;
import com.example.demo.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public Pagination getClients(@RequestParam(required = false) ClientTypeEnum type,
			@RequestParam(required = false) Region region, @RequestParam int page) {

		if (type == null && region == null) {
			return clientRepository.getPaginatedClients(page);
		} else if (type != null && region != null) {
			return clientRepository.getPaginatedClientsWParams(page, region, type);
		} else {
			throw new Error("Os dois parametros devem ser fornecidos");
		}
	}
}
