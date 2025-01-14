package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import com.pracazaliczeniowa.pracazaliczeniowa.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class OrderController {

    @Autowired
    private ClientServiceImpl clientService;

    // Endpoint 1: Pobierz wszystkich klientów
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Endpoint 2: Dodaj nowego klienta
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }
}

