package com.example.fitness.repository;

import com.example.fitness.model.ServiceMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceMenuRepository extends JpaRepository<ServiceMenu, Long> {
}
