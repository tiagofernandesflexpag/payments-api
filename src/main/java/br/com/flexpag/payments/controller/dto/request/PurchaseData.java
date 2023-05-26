package br.com.flexpag.payments.controller.dto.request;
import br.com.flexpag.payments.model.invoice.Invoice;

import java.util.List;

public record PurchaseData(Long amount, Long invoiceAmount, Double rate, Long clientId, List<Long> invoiceIds) {}
