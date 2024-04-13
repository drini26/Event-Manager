package com.project.eventmanager.controller;

import com.project.eventmanager.model.Guest;
import com.project.eventmanager.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/guest/")
public class GuestController {
    private final GuestService guestService;
    @Autowired
    public GuestController(GuestService guestService){
        this.guestService=guestService;
    }

    @PostMapping("create/")
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest){
        guestService.createGuest(guest);
        return new ResponseEntity<>(guest , HttpStatus.CREATED);
    }
    @PostMapping("create/list/")
    public ResponseEntity<List<Guest>> createGuests(@RequestBody List<Guest> guests){
        guestService.createGuests(guests);
        return new ResponseEntity<>(guests , HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Guest> readGuest(@PathVariable long id){
        Guest guest = guestService.readGuest(id).getBody();
        return new ResponseEntity<>(guest , HttpStatus.ACCEPTED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest , @PathVariable long id){
        guestService.updateGuest(id , guest);
        return new ResponseEntity<>(guest , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable long id){
        guestService.deleteGuest(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}
