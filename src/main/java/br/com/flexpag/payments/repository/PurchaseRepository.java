package br.com.flexpag.payments.repository;

import br.com.flexpag.payments.model.purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
