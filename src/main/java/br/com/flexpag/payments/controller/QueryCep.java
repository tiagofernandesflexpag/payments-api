package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.CepResulRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class QueryCep {

    @GetMapping("{cep}")
    public CepResulRecord consultaCep (@PathVariable("cep") String cep) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CepResulRecord> viaCepReponse =
                restTemplate
                        .getForEntity(
                                String.format("https://viacep.com.br/ws/%s/json", cep),
                                CepResulRecord.class);

        return viaCepReponse.getBody();
    }

}
