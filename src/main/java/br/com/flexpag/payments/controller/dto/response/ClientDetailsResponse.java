package br.com.flexpag.payments.controller.dto.response;

import br.com.flexpag.payments.model.client.Client;

public record ClientDetailsResponse(Long id, Long userId, String name, Long contractNumber, Long addressId) {

    public ClientDetailsResponse(Client client){
        this(client.getId(), client.getUserId(), client.getName(), client.getContractNumber(), client.getAddress().getId());
    }

}
