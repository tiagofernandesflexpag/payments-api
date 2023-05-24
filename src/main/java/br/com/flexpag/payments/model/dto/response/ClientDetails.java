package br.com.flexpag.payments.model.dto.response;

import br.com.flexpag.payments.model.address.Address;
import br.com.flexpag.payments.model.client.Client;

public record ClientDetails(Long id, String name, String email, Long contractNumber, Address address) {

    public ClientDetails(Client client){
        this(client.getId(), client.getName(), client.getEmail(), client.getContractNumber(), client.getAddress());
    }

}
