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

import com.insuremyteam.entities.Client;
import com.insuremyteam.entities.InsurancePolicy;
import com.insuremyteam.services.ClientService;
import com.insuremyteam.services.InsurancePlocyService;

import jakarta.validation.Valid;

@RequestMapping("/api/policies")
@RestController
public class InsurancePolicyController {
	
	@Autowired
	private InsurancePlocyService policyService;
	
	@GetMapping("/")
	ResponseEntity<List<InsurancePolicy>> getAllPolicies(){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.policyService.getAllInsurancePolicies());
	}
	
	@GetMapping("/{id}")
	ResponseEntity<InsurancePolicy> getPlicy(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(this.policyService.getInsurancePolicy(id));
	}
	
	@PostMapping("/")
	ResponseEntity<InsurancePolicy> createNewPolicy(@Valid @RequestBody InsurancePolicy policy){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.policyService.createNewInsurancePlicy(policy));
	}
	
	@PutMapping("/{id}")
	ResponseEntity<InsurancePolicy> updateClient(@Valid @RequestBody InsurancePolicy policy,
							@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.policyService.updateInsurancePolicy(id,policy));
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteClient(@PathVariable Integer id){
		this.policyService.deleteInsurancePolicy(id);
		return ResponseEntity.status(HttpStatus.OK).body("Policy Deleted Successfully");
	}

}
