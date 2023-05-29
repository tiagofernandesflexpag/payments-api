package br.com.flexpag.payments.controller.dto.response;

import br.com.flexpag.payments.model.client.Client;

public record ClientDetailsResponse(Long id, String name, Long contractNumber, String email, Long addressId) {

    public ClientDetailsResponse(Client client){
        this(client.getId(), client.getName(), client.getContractNumber(), client.getEmail(), client.getAddress().getId());
    }

}
