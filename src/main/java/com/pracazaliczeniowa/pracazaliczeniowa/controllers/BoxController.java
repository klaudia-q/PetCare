package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Box;
import com.pracazaliczeniowa.pracazaliczeniowa.repositories.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boxes")
public class BoxController {
    @Autowired
    private BoxRepository boxRepository;

    @GetMapping
    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }

    @PostMapping
    public Box createBox(@RequestBody Box box) {
        return boxRepository.save(box);
    }
}
