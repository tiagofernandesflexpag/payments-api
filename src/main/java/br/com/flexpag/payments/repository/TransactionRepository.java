package br.com.flexpag.payments.repository;

import br.com.flexpag.payments.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
