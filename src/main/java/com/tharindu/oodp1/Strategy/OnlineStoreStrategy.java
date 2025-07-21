package com.tharindu.oodp1.Strategy;

interface OnlinePaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements OnlinePaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements OnlinePaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using PayPal.");
    }
}

class CryptoPayment implements OnlinePaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Cryptocurrency.");
    }
}

class PaymentContext {
    private OnlinePaymentStrategy strategy;

    public void setStrategy(OnlinePaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payNow(double amount) {
        if (strategy == null) {
            System.out.println("No payment strategy selected.");
        } else {
            strategy.pay(amount);
        }
    }
}

public class OnlineStoreStrategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.payNow(1500);

        context.setStrategy(new PayPalPayment());
        context.payNow(5000);

        context.setStrategy(new CryptoPayment());
        context.payNow(12000);
    }
}
