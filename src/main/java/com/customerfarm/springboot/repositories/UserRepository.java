package com.customerfarm.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerfarm.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findAll();
	Optional<User> findById(Long id);
	Optional<User> findByUsername(String username);

}
