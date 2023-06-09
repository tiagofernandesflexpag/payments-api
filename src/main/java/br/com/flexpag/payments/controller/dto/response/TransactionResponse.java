package br.com.flexpag.payments.controller.dto.response;

import br.com.flexpag.payments.model.transaction.Transaction;
import br.com.flexpag.payments.model.transaction.enums.PaymentTypeEnum;
import br.com.flexpag.payments.model.transaction.enums.StatusEnum;

import java.util.UUID;

public record TransactionResponse(
        Long id,
        UUID uuid,
        PaymentTypeEnum paymentType,
        StatusEnum status,
        Integer instalments,
        Long purchaseId
) {

    public TransactionResponse(Transaction transaction){
        this(transaction.getId(), transaction.getUuid(), transaction.getPaymentType(), transaction.getStatus(),
                transaction.getInstalments(), transaction.getPurchase().getId()
        );
    }

}
