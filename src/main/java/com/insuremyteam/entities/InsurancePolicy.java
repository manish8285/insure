package com.insuremyteam.entities;

import java.util.Date;

import org.hibernate.annotations.NotFound;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class InsurancePolicy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int policyNumber;
	
	@NotEmpty(message="Policy Type can not be empty or null")
	private String type;
	
	@NotNull(message="Please provide coverage amount")
	@Min(value = 10,message="Please provide a valid coverage amount")
	private double coverageAmount;
	@NotNull(message="Please define premium amount")
	@Min(value = 10,message="Please provide a valid premium amount")
	private double premium;
	
	private Date startDate;
	
	@NotEmpty(message="Please set a valid end date")
	private String endDate;
	
	@NotNull(message="Please provide valid client id")
	@OneToOne
	private Client client;

}
