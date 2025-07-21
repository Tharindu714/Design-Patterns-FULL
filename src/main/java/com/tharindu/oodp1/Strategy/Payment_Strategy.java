package com.tharindu.oodp1.Strategy;

interface PaymentStrategy {
    void pay(double amount);
}

class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Rs." + amount + " paid with cash");
    }
}

class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Rs." + amount + " paid with card");
    }
}

class PaypalPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Rs." + amount + " paid with paypal");
    }
}

class ShoppingCart{
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void Checkout(double amount){
        paymentStrategy.pay(amount);
    }
}

public class Payment_Strategy {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(); //new Shopping Cart Object

        shoppingCart.setPaymentStrategy(new CashPaymentStrategy());
        shoppingCart.Checkout(1000);

        shoppingCart.setPaymentStrategy(new CardPaymentStrategy());
        shoppingCart.Checkout(2000);

        shoppingCart.setPaymentStrategy(new PaypalPaymentStrategy());
        shoppingCart.Checkout(3000);
    }
}
