package com.insuremyteam.services.imples;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.entities.Claim;
import com.insuremyteam.entities.InsurancePolicy;
import com.insuremyteam.exceptions.ResourceNotFoundException;
import com.insuremyteam.repositries.ClaimRepo;
import com.insuremyteam.repositries.InsurancePolicyRepo;
import com.insuremyteam.services.ClaimService;

import jakarta.validation.Valid;

@Service
public class ClaimServiceImple implements ClaimService{
	
	@Autowired
	private ClaimRepo claimRepo;
	
	@Autowired
	private InsurancePolicyRepo policyRepo;

	@Override
	public Claim createNewClaim(Claim claim) {
		InsurancePolicy policy = this.policyRepo.findById(claim.getInsurancePloicy().getPolicyNumber()).orElseThrow(()->new ResourceNotFoundException("Claim", "Id", claim.getInsurancePloicy().getPolicyNumber()));
		claim.setInsurancePloicy(policy);
		claim.setClaimDate(new Date());
		return this.claimRepo.save(claim);
	}

	@Override
	public Claim updateCalim(int id,Claim claim) {
		InsurancePolicy policy = this.policyRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Claim", "Id", id));
		claim.setInsurancePloicy(policy);
		Claim claim2 = this.getClaimById(claim.getClaimNumber());
		claim2.setClaimSatus(claim.getClaimSatus());
		claim2.setDescription(claim.getDescription());
		claim2.setInsurancePloicy(policy);
		return this.claimRepo.save(claim2);
	}

	@Override
	public List<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		return this.claimRepo.findAll();
	}

	@Override
	public Claim getClaimById(int claimId) {
		// TODO Auto-generated method stub
		return this.claimRepo.findById(claimId).orElseThrow(()->new ResourceNotFoundException("Claim", "id", claimId));
	}

	@Override
	public void deleteClaim(int claimId) {
		Claim claim = this.getClaimById(claimId);
		this.claimRepo.delete(claim);
	}

}
