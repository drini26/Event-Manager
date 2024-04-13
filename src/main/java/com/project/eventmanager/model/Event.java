package com.project.eventmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long eventId;
    private String eventName;
    private LocalDateTime eventDateTime;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "EventGuest",
            joinColumns = @JoinColumn(name = "eventId"),
            inverseJoinColumns = @JoinColumn(name = "guestId")
    )
    @JsonIgnoreProperties("events")
    private Set<Guest> guests;
}
