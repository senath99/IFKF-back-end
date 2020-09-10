package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long>{

}
