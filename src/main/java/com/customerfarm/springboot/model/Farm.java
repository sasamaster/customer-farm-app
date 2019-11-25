package com.customerfarm.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table
public class Farm {
	
	@Id
	@GeneratedValue
	private Long id;
	private String farmName;
	private Double price;
	
	@ToString.Exclude
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	

}
