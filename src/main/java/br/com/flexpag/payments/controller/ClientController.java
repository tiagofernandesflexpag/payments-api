package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.CreateClientData;
import br.com.flexpag.payments.controller.dto.response.ClientDetailsResponse;
import br.com.flexpag.payments.model.client.Client;
import br.com.flexpag.payments.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cliente")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createClient(@RequestBody @Valid CreateClientData createClientDataDTO, UriComponentsBuilder uriBuilder){

    var client = new Client(createClientDataDTO);

    clientRepository.save(client);

        var uri = uriBuilder.path("/cliente/{id}")
                .buildAndExpand(client.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new ClientDetailsResponse(client));
    }

}
