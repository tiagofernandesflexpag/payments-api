package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.model.dto.request.CreateClient;
import br.com.flexpag.payments.model.dto.response.ClientDetails;
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
    public ResponseEntity createClient(@RequestBody @Valid CreateClient createClientDTO, UriComponentsBuilder uriBuilder){

    var client = new Client(createClientDTO);

    clientRepository.save(client);

        var uri = uriBuilder.path("/client/{id}")
                .buildAndExpand(client.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new ClientDetails(client));
    }


}
