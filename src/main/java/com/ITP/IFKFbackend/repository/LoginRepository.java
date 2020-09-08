package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITP.IFKFbackend.model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
	

}
