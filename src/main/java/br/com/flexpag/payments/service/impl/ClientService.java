package br.com.flexpag.payments.service.impl;

import br.com.flexpag.payments.controller.dto.request.CreateClientData;
import br.com.flexpag.payments.model.client.Client;
import br.com.flexpag.payments.repository.ClientRepository;
import br.com.flexpag.payments.service.ClientServiceContract;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientServiceContract {

    @Autowired
    ClientRepository clientRepository;

    public Client createClient(CreateClientData createClientData){

        var client = clientRepository.save(new Client(createClientData));

        return client;

    }

    public Client getClient(Long clientId) {

        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

        return client;

    }
}
