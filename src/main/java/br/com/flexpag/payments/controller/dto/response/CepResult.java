package br.com.flexpag.payments.controller.dto.response;

public record CepResult(
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {}
