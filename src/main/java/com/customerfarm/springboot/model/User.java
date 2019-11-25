package com.customerfarm.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "User")
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String role;
	
	@ToString.Exclude
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	 

}
