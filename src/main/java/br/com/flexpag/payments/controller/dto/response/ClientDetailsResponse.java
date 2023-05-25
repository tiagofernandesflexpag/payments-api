package br.com.flexpag.payments.controller.dto.response;

import br.com.flexpag.payments.model.client.Client;

public record ClientDetailsResponse(Long id, String name, String email, Long contractNumber, Long addressId) {

    public ClientDetailsResponse(Client client){
        this(client.getId(), client.getName(), client.getEmail(), client.getContractNumber(), client.getAddress().getId());
    }

}
