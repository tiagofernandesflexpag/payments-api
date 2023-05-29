package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.CreateClientData;
import br.com.flexpag.payments.controller.dto.response.ClientDetailsResponse;
import br.com.flexpag.payments.service.impl.ClientService;
import br.com.flexpag.payments.util.UriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    @Transactional
    public ResponseEntity createClient(@RequestBody @Valid CreateClientData createClientData, UriComponentsBuilder uriBuilder){

        var client = clientService.createClient(createClientData);

        URI location = UriBuilder.buildUri(ServletUriComponentsBuilder.fromCurrentRequest(), "/client/{id}", client.getId());

        var clientResponse = new ClientDetailsResponse(client);

        return ResponseEntity.created(location).body(clientResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity getClient(@PathVariable Long id){

        var client = clientService.getClient(id);

        var clientResponse = new ClientDetailsResponse(client);

        return ResponseEntity.ok().body(clientResponse);

    }

}
