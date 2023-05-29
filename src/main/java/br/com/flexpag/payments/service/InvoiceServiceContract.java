package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.InvoiceData;
import br.com.flexpag.payments.model.invoice.Invoice;

public interface InvoiceServiceContract {

    Invoice addInvoice(InvoiceData invoiceData);

    void updatePaymentStatus(Long purchaseId);
}
