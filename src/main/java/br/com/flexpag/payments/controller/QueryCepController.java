package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.response.CepDetailsResponse;
import br.com.flexpag.payments.controller.dto.response.RestCepResult;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class QueryCepController {

    @GetMapping("{cep}")
    public CepDetailsResponse consultaCep (@PathVariable("cep") String cep) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<RestCepResult> viaCepReponse =
                restTemplate
                        .getForEntity(
                                String.format("https://viacep.com.br/ws/%s/json", cep),
                                RestCepResult.class);

        RestCepResult restCepResult = viaCepReponse.getBody();

        CepDetailsResponse cepDetailsResponse = new CepDetailsResponse(
                restCepResult.logradouro(),
                "",
                restCepResult.localidade(),
                restCepResult.uf(),
                ""
        );

        return cepDetailsResponse;
    }

}
