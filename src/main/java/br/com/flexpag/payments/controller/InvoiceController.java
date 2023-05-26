package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.InvoiceData;
import br.com.flexpag.payments.controller.dto.response.CreateInvoiceResponse;
import br.com.flexpag.payments.model.invoice.Invoice;
import br.com.flexpag.payments.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    @Transactional
    public ResponseEntity<CreateInvoiceResponse> addInvoice(@RequestBody @Valid InvoiceData invoiceData){

        var invoice = invoiceService.addInvoice(invoiceData);

        var invoiceResponse = new CreateInvoiceResponse(invoice);

        return ResponseEntity.ok().body(invoiceResponse);

    }

    @GetMapping("/{contractNumber}")
    @Cacheable(value = "invoicesByContract", key = "#contractNumber")
    public ResponseEntity<List<Invoice>> getInvoicesByContractNumber(@PathVariable Long contractNumber){

        var invoices = invoiceService.getInvoicesByContractNumber(contractNumber);

        return ResponseEntity.ok().body(invoices);

    }

}
