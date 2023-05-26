package br.com.flexpag.payments.util;

import br.com.flexpag.payments.model.transaction.enums.StatusEnum;

import java.util.Random;

public class RandomPaymentStatus {
    private static final Random random = new Random();

    public static StatusEnum getRandomStatus() {
        StatusEnum[] values = StatusEnum.values();
        return values[random.nextInt(values.length)];
    }

}
