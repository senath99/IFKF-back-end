package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.GradingExaminations;

@Repository
public interface GradingExaminationsRepository extends JpaRepository<GradingExaminations, String> {

}
