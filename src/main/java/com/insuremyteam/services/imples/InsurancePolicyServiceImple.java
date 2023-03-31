package com.insuremyteam.services.imples;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.entities.Client;
import com.insuremyteam.entities.InsurancePolicy;
import com.insuremyteam.exceptions.ResourceNotFoundException;
import com.insuremyteam.repositries.ClientRepo;
import com.insuremyteam.repositries.InsurancePolicyRepo;
import com.insuremyteam.services.InsurancePlocyService;

@Service
public class InsurancePolicyServiceImple implements InsurancePlocyService{
	
	@Autowired
	private InsurancePolicyRepo policyRepo;
	
	@Autowired
	private ClientRepo clientRepo;

	@Override
	public InsurancePolicy createNewInsurancePlicy(InsurancePolicy insurancePlicy) {
		Client client = this.clientRepo.findById(insurancePlicy.getClient().getId()).orElseThrow(()->new ResourceNotFoundException("Client","id",insurancePlicy.getClient().getId()));
		insurancePlicy.setClient(client);
		insurancePlicy.setStartDate(new Date());
		return this.policyRepo.save(insurancePlicy);
	}

	@Override
	public InsurancePolicy updateInsurancePolicy(int id,InsurancePolicy insurancePolicy) {
		InsurancePolicy policy = this.getInsurancePolicy(id);
		policy.setCoverageAmount(insurancePolicy.getCoverageAmount());
		
		Client client = this.clientRepo.findById(insurancePolicy.getClient().getId()).orElseThrow(()->new ResourceNotFoundException("Client", "id", insurancePolicy.getClient().getId()));
		
		policy.setClient(client);
		policy.setEndDate(insurancePolicy.getEndDate());
		policy.setPremium(insurancePolicy.getPremium());
		policy.setType(insurancePolicy.getType());
		
		return this.policyRepo.save(policy);
	}

	@Override
	public InsurancePolicy getInsurancePolicy(int policyNo) {
		return this.policyRepo.findById(policyNo).orElseThrow(()->new ResourceNotFoundException("Insurance Policy", "id", policyNo));
	}

	@Override
	public List<InsurancePolicy> getAllInsurancePolicies() {
		// TODO Auto-generated method stub
		return this.policyRepo.findAll();
	}

	@Override
	public void deleteInsurancePolicy(int policyNo) {
		InsurancePolicy policy = this.getInsurancePolicy(policyNo);
		this.policyRepo.delete(policy);
	}

}
