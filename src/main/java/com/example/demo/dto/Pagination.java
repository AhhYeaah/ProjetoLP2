package com.example.demo.dto;

import java.util.List;

public class Pagination {
	private final int PAGINATION_SIZE = 25;

	public int pageNumber;
	public int pageSize = PAGINATION_SIZE;
	public long totalCount;
	public List<Client> users;

	public Pagination(int pageNumber) {
		super();
		this.pageNumber = pageNumber;
	}
}
