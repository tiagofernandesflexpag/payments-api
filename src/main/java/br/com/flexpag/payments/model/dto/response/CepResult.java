package br.com.flexpag.payments.model.dto.response;

public record CepResult(
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {}
