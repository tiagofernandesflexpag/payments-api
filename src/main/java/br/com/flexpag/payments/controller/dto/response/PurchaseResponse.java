package br.com.flexpag.payments.controller.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record PurchaseResponse(
        LocalDate createdAt,
        LocalDate updatedAt,
        Long id,
        UUID uuid,
        Long amount,
        Long invoiceAmount,
        Double rate,
        Long clientId
) {}
