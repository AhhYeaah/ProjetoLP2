package com.example.demo.repository;

import com.example.demo.Enums.ClientTypeEnum;
import com.example.demo.Enums.Region;
import com.example.demo.dto.Pagination;

public interface PaginatedClientRepository {
	public Pagination getPaginatedClients(int page);

	public Pagination getPaginatedClientsWParams(int page, Region region, ClientTypeEnum type);
}
