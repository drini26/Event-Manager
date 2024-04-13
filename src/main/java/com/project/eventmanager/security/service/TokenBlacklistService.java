package com.project.eventmanager.security.service;

import com.project.eventmanager.security.model.BlacklistToken;
import com.project.eventmanager.security.repository.BlacklistTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenBlacklistService {

    public final BlacklistTokenRepository blacklistTokenRepository;

    public void blacklistToken(String token){
        blacklistTokenRepository.save(new BlacklistToken(token));
    }

    public boolean isTokenBlacklisted(String token){
        return blacklistTokenRepository.existsById(token);
    }
}