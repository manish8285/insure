package com.insuremyteam.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuremyteam.entities.InsurancePolicy;

public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Integer> {

}
