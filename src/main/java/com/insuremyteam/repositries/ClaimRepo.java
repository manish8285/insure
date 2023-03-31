package com.insuremyteam.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuremyteam.entities.Claim;

public interface ClaimRepo extends JpaRepository<Claim, Integer> {

}
