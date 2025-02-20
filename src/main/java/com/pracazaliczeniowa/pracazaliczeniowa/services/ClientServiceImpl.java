package com.pracazaliczeniowa.pracazaliczeniowa.services;


import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import com.pracazaliczeniowa.pracazaliczeniowa.repositores.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public long getClientCount() {
        return 15;
    }



    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
