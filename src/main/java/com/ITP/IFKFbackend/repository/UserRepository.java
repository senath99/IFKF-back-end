package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITP.IFKFbackend.model.Student;
import com.ITP.IFKFbackend.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	

}
