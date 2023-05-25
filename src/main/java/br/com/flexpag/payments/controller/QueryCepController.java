package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.response.CepResponse;
import br.com.flexpag.payments.controller.dto.response.RestCepResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class QueryCepController {

    @GetMapping("{cep}")
    public CepResponse consultaCep (@PathVariable("cep") String cep) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<RestCepResult> viaCepReponse =
                restTemplate
                        .getForEntity(
                                String.format("https://viacep.com.br/ws/%s/json", cep),
                                RestCepResult.class);

        RestCepResult restCepResult = viaCepReponse.getBody();

        CepResponse cepResponse = new CepResponse(
                restCepResult.logradouro(),
                "",
                restCepResult.localidade(),
                restCepResult.uf(),
                ""
        );

        return cepResponse;
    }

}
