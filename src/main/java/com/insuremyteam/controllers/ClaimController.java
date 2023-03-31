package com.insuremyteam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuremyteam.entities.Claim;
import com.insuremyteam.entities.Client;
import com.insuremyteam.services.ClaimService;
import com.insuremyteam.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/claims")

public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@GetMapping("/")
	ResponseEntity<List<Claim>> getAllClaims(){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.claimService.getAllClaims());
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Claim> getClient(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(this.claimService.getClaimById(id));
	}
	
	@PostMapping("/")
	ResponseEntity<Claim> createNewClaim(@Valid @RequestBody Claim claim){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.claimService.createNewClaim(claim));
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Claim> updateClaim(@Valid @RequestBody Claim claim,
									@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.claimService.updateCalim(id,claim));
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteClaim(@PathVariable Integer id){
		this.claimService.deleteClaim(id);
		return ResponseEntity.status(HttpStatus.OK).body("Claim Deleted Successfully");
	}

}
