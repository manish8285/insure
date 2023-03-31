package com.insuremyteam.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Claim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int claimNumber;
	
	@NotEmpty(message="Description can not be null or empty")
	private String description;
	
	private Date claimDate;
	
	@NotEmpty(message="Claim status can not be null or empty")
	private String claimSatus;
	
	@NotNull(message="Please provide ploicy number")
	@OneToOne
	private InsurancePolicy insurancePloicy;
	
	

}
