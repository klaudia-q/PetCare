package com.pracazaliczeniowa.pracazaliczeniowa.services;


import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> getAllClients();
    public long getClientCount();
}