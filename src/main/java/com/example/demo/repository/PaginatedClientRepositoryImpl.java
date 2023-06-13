package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Enums.ClientTypeEnum;
import com.example.demo.Enums.Region;
import com.example.demo.dto.Client;
import com.example.demo.dto.Pagination;
import com.example.demo.model.ClientModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PaginatedClientRepositoryImpl implements PaginatedClientRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Pagination getPaginatedClients(int page) {
		Pagination paginationResponse = new Pagination(page);

		int noOfRecords = paginationResponse.pageSize;
		int pageIndex = paginationResponse.pageNumber;

		int numOfRows = entityManager.createQuery("SELECT c FROM ClientModel c", ClientModel.class).getResultList()
				.size();

		List<ClientModel> clientList = entityManager.createQuery("SELECT c FROM ClientModel c", ClientModel.class)
				.setMaxResults(noOfRecords).setFirstResult(pageIndex * noOfRecords).getResultList();

		paginationResponse.totalCount = numOfRows;

		List<Client> dtoList = new ArrayList<Client>();
		for (int a = 0; a < clientList.size(); a++) {
			dtoList.add(new Client(clientList.get(a)));
		}

		paginationResponse.users = dtoList;

		return paginationResponse;
	}

	public Pagination getPaginatedClientsWParams(int page, Region region, ClientTypeEnum type) {
		Pagination paginationResponse = new Pagination(page);

		int noOfRecords = paginationResponse.pageSize;
		int pageIndex = paginationResponse.pageNumber;

		int numOfRows = entityManager
				.createQuery("SELECT s FROM ClientModel s WHERE s.region = :region and s.type = :type",
						ClientModel.class)
				.setParameter("region", region).setParameter("type", type).getResultList().size();

		List<ClientModel> clientList = entityManager
				.createQuery("SELECT s FROM ClientModel s WHERE s.region = :region and s.type = :type",
						ClientModel.class)
				.setParameter("region", region).setParameter("type", type).setMaxResults(noOfRecords)
				.setFirstResult(pageIndex * noOfRecords).getResultList();

		paginationResponse.totalCount = numOfRows;

		List<Client> dtoList = new ArrayList<Client>();
		for (int a = 0; a < clientList.size(); a++) {
			dtoList.add(new Client(clientList.get(a)));
		}

		paginationResponse.users = dtoList;

		return paginationResponse;
	}

}
