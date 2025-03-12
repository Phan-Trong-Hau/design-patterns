package org.StrategyPattern;

interface PaymentStrategy {
    void pay(double amount);
}

class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ bằng Tiền mặt.");
    }
}

class BankTransferStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ qua Chuyển khoản.");
    }
}

class MoMoStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ qua MoMo.");
    }
}

class Checkout {
    private PaymentStrategy paymentStrategy;

    public Checkout(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class BaiTap01 {
    public static void main(String[] args) {
        Checkout checkout = new Checkout(new BankTransferStrategy());
        checkout.processOrder(1000000);

        Checkout checkout2 = new Checkout(new CashPaymentStrategy());
        checkout2.processOrder(2000000);

        Checkout checkout3 = new Checkout(new MoMoStrategy());
        checkout3.processOrder(3000000);
    }
}
