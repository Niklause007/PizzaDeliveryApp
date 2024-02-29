package com.example.PizzaDelivery.exception;

public class PaymentFailedException extends Exception{
    public PaymentFailedException(String msg){
        super(msg);
    }

    public PaymentFailedException(){
        super("Payment Failed!");
    }
}
