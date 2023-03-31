package com.insuremyteam.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuremyteam.entities.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {

}
