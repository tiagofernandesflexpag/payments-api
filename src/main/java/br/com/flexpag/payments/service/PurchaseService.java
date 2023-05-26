package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.PurchaseData;
import br.com.flexpag.payments.controller.dto.response.PurchaseResponse;
import br.com.flexpag.payments.model.client.Client;
import br.com.flexpag.payments.model.invoice.Invoice;
import br.com.flexpag.payments.model.purchase.Purchase;
import br.com.flexpag.payments.repository.ClientRepository;
import br.com.flexpag.payments.repository.InvoiceRepository;
import br.com.flexpag.payments.repository.PurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    public Purchase createPurchase(PurchaseData purchaseData){

        Client client = clientRepository.findById(purchaseData.clientId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        List<Invoice> invoices = invoiceRepository.findAllById(purchaseData.invoiceIds());

        Purchase purchase = new Purchase(purchaseData, client, invoices);

        return purchaseRepository.save(purchase);

    }

}
