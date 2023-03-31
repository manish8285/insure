package com.insuremyteam.services;

import java.util.List;

import com.insuremyteam.entities.Claim;

public interface ClaimService {
	
	Claim createNewClaim(Claim claim);
	
	Claim updateCalim(int id,Claim claim);
	
	List<Claim> getAllClaims();
	
	Claim getClaimById(int claimId);
	
	void deleteClaim(int claimId);

}
