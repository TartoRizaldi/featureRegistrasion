package com.example.fitness.repository;

import com.example.fitness.model.Participant;
import com.example.fitness.model.ServiceMenu;
import com.example.fitness.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByParticipantAndServiceMenu(Participant participant, ServiceMenu serviceMenu);
}
