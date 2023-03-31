package com.insuremyteam.services;

import java.util.List;

import com.insuremyteam.entities.InsurancePolicy;

public interface InsurancePlocyService {
	
	InsurancePolicy createNewInsurancePlicy(InsurancePolicy insurancePlicy);

	InsurancePolicy updateInsurancePolicy(int id,InsurancePolicy insurancePolicy);
	
	InsurancePolicy getInsurancePolicy(int policyNo);
	
	List<InsurancePolicy> getAllInsurancePolicies();
	
	void deleteInsurancePolicy(int policyNo);
}
