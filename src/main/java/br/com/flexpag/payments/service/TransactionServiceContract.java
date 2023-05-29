package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.PersistTransactionData;
import br.com.flexpag.payments.model.transaction.Transaction;

public interface TransactionServiceContract {

    Transaction persistTransaction(PersistTransactionData persistTransactionData);

}
