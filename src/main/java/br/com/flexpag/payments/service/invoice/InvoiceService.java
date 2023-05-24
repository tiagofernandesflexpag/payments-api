package br.com.flexpag.payments.service.invoice;

import br.com.flexpag.payments.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public void getInvoices(Long contractNumber){}

}
