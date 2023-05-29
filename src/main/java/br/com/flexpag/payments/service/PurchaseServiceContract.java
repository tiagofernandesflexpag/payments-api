package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.PurchaseData;
import br.com.flexpag.payments.model.purchase.Purchase;

public interface PurchaseServiceContract {

    Purchase createPurchase(PurchaseData purchaseData);

}
