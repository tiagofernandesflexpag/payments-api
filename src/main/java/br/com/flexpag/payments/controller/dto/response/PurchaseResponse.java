package br.com.flexpag.payments.controller.dto.response;

import br.com.flexpag.payments.model.purchase.Purchase;

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
) {

    public PurchaseResponse(Purchase purchase){
        this(purchase.getCreatedAt(), purchase.getUpdatedAt(), purchase.getId(), purchase.getUuid(),
                purchase.getAmount(), purchase.getInvoiceAmount(), purchase.getRate(), purchase.getClient().getId());
    }

}
