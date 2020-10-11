package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ITP.IFKFbackend.Dto.Donate_Session;
import com.ITP.IFKFbackend.Dto.DonationSort;
import com.ITP.IFKFbackend.model.Donations;
import com.ITP.IFKFbackend.model.Rankings;



public interface DonationsRepository extends JpaRepository<Donations,Long>{
	
	
	@Query("from Donations d JOIN d.equipment e  WHERE  d.quantity LIKE %:searchText%  OR e.type LIKE %:searchText% " )
	List<Donations> searchQuery(@Param("searchText") String searchText);
	

	@Query("SELECT new com.ITP.IFKFbackend.Dto.DonationSort(s.sessionId,SUM(d.quantity),e.id,e.type)  FROM Donations d JOIN d.sessions s JOIN d.equipment e  WHERE e.type LIKE %:searchText% " )
	List<DonationSort> searchQuantity(@Param("searchText")String searchText);
	
	
	@Query("SELECT new com.ITP.IFKFbackend.Dto.DonationSort(s.sessionId,SUM(d.quantity),e.id,e.type) FROM Donations d JOIN d.sessions s JOIN d.equipment e    GROUP BY s.sessionId,e.id ")
	List<DonationSort> findQuantitybySessionId();


	
	
	
//	@Query("SELECT new com.ITP.IFKFbackend.Dto.Donate_Session(d.donateID,s.sessionId,d.quantity,d.donateDate,s.instructorName,e.id,e.type) FROM Donations d JOIN d.sessions s JOIN d.equipment e ") 
//	public List<Donate_Session> getjoinInformations();

	
//	@Query("FROM Donations d  ORDER BY  d.donateID DESC")
//	public List<Donations> getLastID();
	
	
//	  Donations findOrderByquantity();
	
	//@Query("SELECT SUM(d.quantity) FROM Sessions s INNER JOIN  Donations d  ON d.sessions_id = s.id  INNER JOIN Equipment e  ON d.equipment_id = e.id GROUP BY "
//			+ "Sessions,Equipment")
//		List<Donations> FindTotal();

	
	
}
