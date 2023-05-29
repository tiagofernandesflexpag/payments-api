package br.com.flexpag.payments.controller.dto.response;

import br.com.flexpag.payments.model.invoice.Invoice;

import java.time.LocalDate;
import java.util.UUID;

public record CreateInvoiceResponse(Long id, UUID uuid, Long amount, String barcode, Long contractNumber, LocalDate dueDate, Boolean paid) {

    public CreateInvoiceResponse(Invoice invoice){
        this(invoice.getId(), invoice.getUuid(), invoice.getAmount(), invoice.getBarcode(), invoice.getContractNumber(), invoice.getDueDate(), invoice.getPaid());
    }


}
