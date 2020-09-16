package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ITP.IFKFbackend.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

	
	@Query("from Equipment e WHERE  e.Type LIKE %:searchText% " )
	List<Equipment> searchEquip(@Param("searchText") String searchText);
}
