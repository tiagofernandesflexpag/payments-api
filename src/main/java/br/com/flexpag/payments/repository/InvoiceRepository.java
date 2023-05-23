package br.com.flexpag.payments.repository;

import br.com.flexpag.payments.model.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
