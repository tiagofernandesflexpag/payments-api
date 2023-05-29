package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.PurchaseData;
import br.com.flexpag.payments.controller.dto.response.PurchaseResponse;
import br.com.flexpag.payments.model.purchase.Purchase;
import br.com.flexpag.payments.service.impl.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    @Transactional
    public ResponseEntity<PurchaseResponse> createPurchase(@RequestBody @Valid PurchaseData purchaseData){

        Purchase purchase = purchaseService.createPurchase(purchaseData);

        PurchaseResponse purchaseResponse = new PurchaseResponse(purchase);

        return ResponseEntity.ok(purchaseResponse);

    }

}
