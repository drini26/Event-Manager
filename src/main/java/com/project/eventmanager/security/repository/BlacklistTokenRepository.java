package com.project.eventmanager.security.repository;

import com.project.eventmanager.security.model.BlacklistToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistTokenRepository extends JpaRepository<BlacklistToken, String> {
}