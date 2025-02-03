package com.pracazaliczeniowa.pracazaliczeniowa.services;


import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import com.pracazaliczeniowa.pracazaliczeniowa.repositores.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {

        List<Client> clientList = new ArrayList<>();
        clientList=clientRepository.findAll();
        return clientList;
    }

    @Override
    public Client createClient(Client client) {
        clientRepository.save(client);
        return client;
    }

}
