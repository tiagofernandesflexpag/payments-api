package br.com.flexpag.payments.controller.dto.response;

public record RestCepResult(
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {}
