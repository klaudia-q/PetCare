package com.pracazaliczeniowa.pracazaliczeniowa.services;


import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    // Pobierz listę wszystkich klientów
    List<Client> getAllClients();

    // Dodaj nowego klienta
    Client createClient(Client client);

}

