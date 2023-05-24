package br.com.flexpag.payments.repository;

import br.com.flexpag.payments.model.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByContractNumberAndPaid(Long contractNumber, Boolean paid);

}
