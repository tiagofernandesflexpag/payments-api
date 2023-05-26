package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.PersistTransactionData;
import br.com.flexpag.payments.controller.dto.response.TransactionResponse;
import br.com.flexpag.payments.exceptions.PaymentStatusException;
import br.com.flexpag.payments.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    @Transactional
    public ResponseEntity persistTransaction(@RequestBody @Valid PersistTransactionData persistTransactionData){

        try {

            var transaction = transactionService.persistTransaction(persistTransactionData);

            TransactionResponse transactionResponse = new TransactionResponse(
                    transaction.getId(),
                    transaction.getUuid(),
                    transaction.getPaymentType(),
                    transaction.getStatus(),
                    transaction.getInstalments(),
                    transaction.getPurchase().getId()
            );

            return ResponseEntity.ok().body(transactionResponse);

        }catch (PaymentStatusException e){

            System.out.println(e);

            return ResponseEntity.ok().body("Erro: " + e.getMessage());

        }

    }

}
