package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.PersistTransactionData;
import br.com.flexpag.payments.exceptions.PaymentStatusException;
import br.com.flexpag.payments.model.transaction.Transaction;
import br.com.flexpag.payments.model.transaction.enums.StatusEnum;
import br.com.flexpag.payments.repository.PurchaseRepository;
import br.com.flexpag.payments.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.flexpag.payments.util.RandomPaymentStatus.getRandomStatus;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    InvoiceService invoiceService;

    public Transaction persistTransaction(PersistTransactionData persistTransactionData){

        var purchaseObject = purchaseRepository.findById(persistTransactionData.purchaseId())
                .orElseThrow(() -> new EntityNotFoundException("Id de purchase não encontrado"));

        StatusEnum randomStatus = getRandomStatus();

        Transaction transaction = new Transaction(persistTransactionData, purchaseObject, randomStatus);

        var savedTransaction = transactionRepository.save(transaction);

        if(randomStatus.equals(StatusEnum.PENDING) || randomStatus.equals(StatusEnum.CANCELLED)){
            throw new PaymentStatusException("Pagamento não autorizado");
        }

        invoiceService.updatePaymentStatus(purchaseObject.getId());

        return savedTransaction;

    }


}
