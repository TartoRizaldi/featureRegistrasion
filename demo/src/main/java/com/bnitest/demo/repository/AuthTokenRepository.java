package com.example.fitness.repository;

import com.example.fitness.model.AuthToken;
import com.example.fitness.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
    AuthToken findByToken(String token);

    @Transactional
    void deleteByToken(String token);
}
