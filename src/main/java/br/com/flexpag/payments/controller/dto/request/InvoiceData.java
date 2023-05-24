package br.com.flexpag.payments.controller.dto.request;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record InvoiceData(
        @NotNull(message = "Quantidade não pode ser nula")
        Long amount,
        @NotBlank
        String barcode,
        @NotNull
        Long contractNumber,
        @NotNull
        LocalDate dueDate,
        @AssertFalse
        Boolean paid
) {}
