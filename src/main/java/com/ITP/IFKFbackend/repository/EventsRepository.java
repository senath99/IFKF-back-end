package com.ITP.IFKFbackend.repository;

import com.ITP.IFKFbackend.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {
//    List<Events>findByEventName(String eventName);
}
