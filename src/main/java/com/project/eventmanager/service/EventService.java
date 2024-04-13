package com.project.eventmanager.service;

import com.project.eventmanager.model.Event;
import com.project.eventmanager.repository.EventRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @PersistenceContext
    private EntityManager entityManager;
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }

    public void createEvent(Event event) {eventRepository.save(event);
    }
    public void createEvents(List<Event> event){
        eventRepository.saveAll(event);
    }
    public Event readEvent(long id){
        return eventRepository.findEventByEventId(id);
    }
    @Transactional
    public void updateEvent(long id , Event newEvent){
        Event event = eventRepository.findEventByEventId(id);
        event.setEventName(newEvent.getEventName());
        event.setEventDateTime(newEvent.getEventDateTime());
    }
    @Transactional
    public void deleteEvent(long id){
        entityManager.createNativeQuery("DELETE FROM event_guest WHERE event_id = ?1")
                .setParameter(1, id)
                .executeUpdate();
        eventRepository.deleteById(id);
    }

}
