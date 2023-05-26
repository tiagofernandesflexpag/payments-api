package br.com.flexpag.payments.controller.dto.request;

import br.com.flexpag.payments.model.client.enums.ContractTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateClientData(
        @NotBlank
        String name,
        @NotBlank
        String identity,
        @NotBlank
        ContractTypeEnum contract,
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotNull
        Long contractNumber,
        @NotBlank
        @Valid
        AddressData address

) {}
