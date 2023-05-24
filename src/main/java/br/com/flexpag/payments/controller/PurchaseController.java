package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.PurchaseData;
import br.com.flexpag.payments.model.purchase.Purchase;
import br.com.flexpag.payments.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    public ResponseEntity<Purchase> createPurchase(PurchaseData purchaseData){

        purchaseService.createPurchase();

        return ResponseEntity.ok().build();
    }

}
