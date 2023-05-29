package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.InvoiceData;
import br.com.flexpag.payments.model.invoice.Invoice;
import java.util.List;

public interface InvoiceServiceContract {

    Invoice addInvoice(InvoiceData invoiceData);

    List<Invoice> getInvoicesByContractNumber(Long contractNumber);

    void updatePaymentStatus(Long purchaseId);

}
