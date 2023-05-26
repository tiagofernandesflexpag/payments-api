package br.com.flexpag.payments.exceptions;

public class PaymentStatusException extends RuntimeException{
    public PaymentStatusException(String msg){
        super(msg);
    }
}
