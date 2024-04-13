package com.project.eventmanager.repository;

import com.project.eventmanager.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
        Guest findGuestByGuestId(long id);
}
