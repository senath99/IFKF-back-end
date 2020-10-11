package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.unregStudent;

@Repository
public interface UnregStudentRepository extends JpaRepository<unregStudent, Long>{

//	@Query("FROM unregStudent us WHERE us.kyu ==%:kyu%")
//	List<unregStudent> filterByKyu(@Param("kyu") String kyu);
	
	
	List<unregStudent> findBykyu(String kyu);
	
	@Query("From unregStudent us Where us.name LIKE %:name%")
	List<unregStudent> searchByName(@Param("name") String name);
}
