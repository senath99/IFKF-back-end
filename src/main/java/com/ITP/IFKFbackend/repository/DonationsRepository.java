package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ITP.IFKFbackend.model.Donations;



public interface DonationsRepository extends JpaRepository<Donations,Long>{
	
	@Query("from Donations d WHERE  d.quantity LIKE %:searchText% " )
	List<Donations> searchQuery(@Param("searchText") String searchText);
	

	
//	@Query("SELECT SUM(d.quantity) FROM Sessions s INNER JOIN  Donations d  ON d.sessions_id = s.id  INNER JOIN Equipment e  ON d.equipment_id = e.id GROUP BY "
//			+ "Sessions,Equipment")
//	List<Donations> FindTotal();


}
