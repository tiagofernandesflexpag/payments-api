package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.CreateClientData;
import br.com.flexpag.payments.model.client.Client;
import br.com.flexpag.payments.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client createClient(CreateClientData createClientData){

        var client = clientRepository.save(new Client(createClientData));

        return client;

    }

}
