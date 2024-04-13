package com.project.eventmanager.service;

import com.project.eventmanager.model.Guest;
import com.project.eventmanager.repository.GuestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GuestService {
    @PersistenceContext
    private EntityManager entityManager;
    private final GuestRepository guestRepository;
    @Autowired
    public GuestService(GuestRepository guestRepository){
        this.guestRepository=guestRepository;
    }
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest){
        guestRepository.save(guest);
        return ResponseEntity.ok(guest);
    }
    public ResponseEntity<List<Guest>> createGuests(@RequestBody List<Guest> guest){
        guestRepository.saveAll(guest);
        return ResponseEntity.ok(guest);
    }
    public ResponseEntity<Guest> readGuest(@RequestParam long id){
        Guest guest = guestRepository.findGuestByGuestId(id);
        return ResponseEntity.ok(guest);
    }
    @Transactional
    public ResponseEntity<Guest> updateGuest(@RequestParam long id,@RequestBody Guest newGuest){
        Guest guest = guestRepository.findGuestByGuestId(id);
        guest.setGuestName(newGuest.getGuestName());
        guest.setGuestSurname(newGuest.getGuestSurname());
        guest.setGuestEmail(newGuest.getGuestEmail());
        return ResponseEntity.ok(guest);
    }
@Transactional
    public void deleteGuest(@RequestParam long id){
        Guest guest = guestRepository.findGuestByGuestId(id);
    entityManager.createNativeQuery("DELETE FROM event_guest WHERE guest_id = ?1")
            .setParameter(1, id)
            .executeUpdate();
    
        guestRepository.deleteById(id);
    }

}

