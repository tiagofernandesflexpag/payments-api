package br.com.flexpag.payments.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddressData(
        @NotBlank
        String street,
        @NotBlank
        String number,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String complement
) {}
