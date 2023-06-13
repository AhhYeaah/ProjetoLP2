package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.Client;
import com.example.demo.dto.Pagination;
import com.example.demo.model.ClientModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PaginatedClientService {

	@PersistenceContext
	private EntityManager entityManager;

	public Pagination getPaginatedClients(int page, long totalUsers) {
		Pagination paginationResponse = new Pagination(page);

		int noOfRecords = paginationResponse.pageSize;
		int pageIndex = paginationResponse.pageNumber;

		List<ClientModel> clientList = entityManager.createNamedQuery("paginatedClients", ClientModel.class)
				.setMaxResults(noOfRecords).setFirstResult(pageIndex * noOfRecords).getResultList();

		List<Client> dtoList = new ArrayList<Client>();
		for (int a = 0; a < clientList.size(); a++) {
			dtoList.add(new Client(clientList.get(a)));
		}

		paginationResponse.users = dtoList;

		return paginationResponse;
	}

}
