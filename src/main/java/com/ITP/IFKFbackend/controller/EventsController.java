package com.ITP.IFKFbackend.controller;

import com.ITP.IFKFbackend.model.Events;
import com.ITP.IFKFbackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventController")
@CrossOrigin(origins = "http://localhost:3000")
public class EventsController {

    @Autowired
    private EventsRepository eventsRepository;

//    @Autowired
//    private EventsService eventsService;

    //retrieve all events
    @GetMapping("/events/list")
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
        //return eventsService.findAll();
    }

//    //retrieve specific event id
    @GetMapping("/events/{eventId}")
    public ResponseEntity<?> getEvent(@PathVariable Long eventId) {
    	Optional<Events> events = eventsRepository.findById(eventId);
    	return events.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

//        return eventsService.findById(id);
    }

    //delete an event
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventsRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //update an event
    @PutMapping("/events/update")
    public ResponseEntity<Events> updateEvent(@RequestBody Events event) {
        Events updateEvent = eventsRepository.save(event);
        return new ResponseEntity<Events>(event, HttpStatus.OK);
    }

    //add an event
    @PostMapping("/events")
    public ResponseEntity<Void> createEvent(@RequestBody Events event) {
        Events addEvent = eventsRepository.save(event);

        //location
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addEvent.getEventId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}