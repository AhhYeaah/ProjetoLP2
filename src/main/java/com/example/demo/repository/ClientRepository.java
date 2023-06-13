package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, String>, PaginatedClientRepository {
}
