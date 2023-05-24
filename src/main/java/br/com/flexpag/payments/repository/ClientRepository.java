package br.com.flexpag.payments.repository;

import br.com.flexpag.payments.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}
