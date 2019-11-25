package com.customerfarm.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<User> users = new ArrayList<>();
	
	@ToString.Exclude
	@JsonManagedReference
	@OneToMany(mappedBy = "customer")
	private List<Farm> farms = new ArrayList<>();
	

}
