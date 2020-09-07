package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITP.IFKFbackend.model.Equipment;
import com.ITP.IFKFbackend.model.User;

public interface LoginRepository extends JpaRepository<User, Long>{

	
	
}
