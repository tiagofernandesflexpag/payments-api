package br.com.flexpag.payments.service.invoice;

import br.com.flexpag.payments.controller.dto.request.InvoiceData;
import br.com.flexpag.payments.model.invoice.Invoice;
import br.com.flexpag.payments.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice addInvoice(InvoiceData invoiceData){

        return invoiceRepository.save(new Invoice(invoiceData));

    }

    public List<Invoice> getInvoicesByContractNumber(Long contractNumber) {
        return invoiceRepository.findByContractNumberAndPaid(contractNumber, false);
    }

}
