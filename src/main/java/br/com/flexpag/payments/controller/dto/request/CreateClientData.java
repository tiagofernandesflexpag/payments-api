package br.com.flexpag.payments.controller.dto.request;

import br.com.flexpag.payments.model.client.enums.ContractTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateClientData(
        @NotNull
        Long userId,
        @NotBlank
        String name,
        @NotBlank
        String identity,
        @NotNull
        ContractTypeEnum contract,
        @NotNull
        Long contractNumber,
        @NotNull
        @Valid
        AddressData address

) {}
