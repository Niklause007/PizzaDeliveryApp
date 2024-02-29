package com.example.PizzaDelivery.exception;

public class PizzaNotFoundException extends Exception{
    public PizzaNotFoundException(String msg){
        super(msg);
    }

    public PizzaNotFoundException(){
        super("Pizza not Found!");
    }
}
