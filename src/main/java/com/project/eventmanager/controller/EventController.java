package com.project.eventmanager.controller;

import com.project.eventmanager.model.Event;
import com.project.eventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/event/")
public class EventController {
    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService){
        this.eventService=eventService;
    }

    @PostMapping("create/")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        eventService.createEvent(event);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("create/list/")
    public ResponseEntity<List<Event>> createEvent(@RequestBody List<Event> event){
        eventService.createEvents(event);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Event> readEvent(@PathVariable long id ){
        Event event = eventService.readEvent(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id , @RequestBody Event event ){
        eventService.updateEvent(id, event);
        return new ResponseEntity<>(event , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id ){
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
