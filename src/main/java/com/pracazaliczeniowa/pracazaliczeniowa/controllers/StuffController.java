package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Stuff;
import com.pracazaliczeniowa.pracazaliczeniowa.repositories.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stuff")
public class StuffController {
    @Autowired
    private StuffRepository stuffRepository;

    @GetMapping
    public List<Stuff> getAllStuff() {
        return stuffRepository.findAll();
    }

    @PostMapping
    public Stuff createStuff(@RequestBody Stuff stuff) {
        return stuffRepository.save(stuff);
    }
}
