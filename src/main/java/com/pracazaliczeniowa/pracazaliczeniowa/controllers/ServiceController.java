package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Service;
import com.pracazaliczeniowa.pracazaliczeniowa.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @PostMapping
    public Service createService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }
}
