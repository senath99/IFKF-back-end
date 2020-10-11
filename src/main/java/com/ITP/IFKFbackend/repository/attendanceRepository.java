package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Attendance;
import com.ITP.IFKFbackend.model.Payment;


@Repository 
public interface attendanceRepository extends JpaRepository<Attendance, Long>{
//	public Attendance findTopByOrderBystuIdDesc();
//	
//	List<Attendance> findBystuId(String searchText);
//	 
//	 @Query("from Attendance a WHERE a.stuId = :searchText ORDER BY a.stuId")
//	 List <Attendance> searchQuery (@Param("searchText") String stuId);


}
