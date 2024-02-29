package com.example.PizzaDelivery.exception;

public class CartNotFoundException extends Exception{
    public CartNotFoundException(String msg){
        super(msg);
    }

    public CartNotFoundException(){
        super("Cart not found!");
    }
}
