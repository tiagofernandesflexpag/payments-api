package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.CreateClientData;
import br.com.flexpag.payments.model.client.Client;

public interface ClientServiceContract {

    Client createClient(CreateClientData createClientData);

    Client getClient(Long clientId);

}
