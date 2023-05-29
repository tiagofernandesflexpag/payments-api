package br.com.flexpag.payments.service.impl;

import br.com.flexpag.payments.controller.dto.request.InvoiceData;
import br.com.flexpag.payments.model.invoice.Invoice;
import br.com.flexpag.payments.model.purchase.Purchase;
import br.com.flexpag.payments.repository.InvoiceRepository;
import br.com.flexpag.payments.repository.PurchaseRepository;
import br.com.flexpag.payments.service.InvoiceServiceContract;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements InvoiceServiceContract {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    public Invoice addInvoice(InvoiceData invoiceData){

        return invoiceRepository.save(new Invoice(invoiceData));

    }

    public List<Invoice> getInvoicesByContractNumber(Long contractNumber) {
        return invoiceRepository.findByContractNumberAndPaid(contractNumber, false);
    }

    public void updatePaymentStatus(Long purchaseId){

        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new EntityNotFoundException("Purchase not found with id: " + purchaseId));

        List<Invoice> invoices = purchase.getInvoices();

        for (Invoice invoice : invoices) {
            invoice.setPaid(true);
            invoiceRepository.save(invoice);
        }

    }

}
