package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.model.invoice.Invoice;
import br.com.flexpag.payments.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping("/{contractNumber}")
    public ResponseEntity<List<Invoice>> getInvoices(@PathVariable Long contractNumber) {
        return null;
    }

}
