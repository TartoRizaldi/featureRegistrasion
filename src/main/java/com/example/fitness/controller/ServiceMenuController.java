package com.example.fitness.controller;

import com.example.fitness.model.ServiceMenu;
import com.example.fitness.service.ServiceMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-menu")
public class ServiceMenuController {
    @Autowired
    private ServiceMenuService serviceMenuService;

    @GetMapping("/list")
    public ResponseEntity<List<ServiceMenu>> getAllServiceMenus() {
        List<ServiceMenu> serviceMenus = serviceMenuService.getAllServiceMenus();
        return ResponseEntity.ok(serviceMenus);
    }

}
