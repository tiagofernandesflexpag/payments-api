package br.com.flexpag.payments.controller.dto.request;

import br.com.flexpag.payments.model.transaction.enums.PaymentTypeEnum;
import jakarta.validation.constraints.NotNull;

public record PersistTransactionData(
        @NotNull
        PaymentTypeEnum paymentType,
        @NotNull
        Long authorizationCode,
        @NotNull
        Integer instalments,
        @NotNull
        Long purchaseId
) {}
