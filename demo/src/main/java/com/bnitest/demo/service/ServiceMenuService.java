package com.example.fitness.service;

import com.example.fitness.model.ServiceMenu;
import com.example.fitness.repository.ServiceMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceMenuService {
    @Autowired
    private ServiceMenuRepository serviceMenuRepository;

    public List<ServiceMenu> getAllServiceMenus() {
        return serviceMenuRepository.findAll();
    }

}
