package com.project.eventmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
@NoArgsConstructor
@Entity
@Data
public class Guest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long guestId;
    private String guestName;
    private String guestSurname;
    private String guestEmail;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime registrationDate;

    @ManyToMany(mappedBy = "guests" , cascade = CascadeType.DETACH)
    @JsonIgnoreProperties("guests")
    private Set<Event> events;
}
