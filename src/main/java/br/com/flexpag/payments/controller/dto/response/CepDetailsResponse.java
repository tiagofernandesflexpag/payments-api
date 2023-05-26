package br.com.flexpag.payments.controller.dto.response;

public record CepDetailsResponse(String street, String number, String city, String state, String complement) {
}
