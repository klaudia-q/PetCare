package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import com.pracazaliczeniowa.pracazaliczeniowa.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    // Endpoint 1: Pobierz wszystkich klientów
    @GetMapping(path ="/api/client/ALL ")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path ="/api/client/{clientId}/visitsCount" )
    public Long getAllClients(@PathVariable Long clientId) {
        return clientService.getClientCount();
    }


    // Endpoint 2: Dodaj nowego klienta
}

