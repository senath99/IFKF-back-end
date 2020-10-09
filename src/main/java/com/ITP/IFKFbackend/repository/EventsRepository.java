package com.ITP.IFKFbackend.repository;

import com.ITP.IFKFbackend.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    @Query("SELECT e FROM Events e WHERE e.eventName LIKE %:searchName%")
    List<Events> findEventsByEventName(@Param("searchName") String eventName);

    List<Events> findByEventType(String eventType);

//    @Query("SELECT e FROM Events e WHERE SUBSTRING(e.eventDate,6,2) = :month" )
//    List<Events> findByEventMonth(@Param("month") Integer eventMonth);

}
