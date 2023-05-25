package br.com.flexpag.payments.controller.dto.response;

public record CepResponse(String street, String number, String city, String state, String complement) {
}
