package br.com.flexpag.payments.controller.dto;

public record CepResult(
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {}
