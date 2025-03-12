package org.StatePattern;

interface PaymentState {
    void pay(double amount);
}

class CashPayment implements PaymentState {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ bằng Tiền mặt.");
    }
}

class BankTransferPayment implements PaymentState {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ qua Chuyển khoản.");
    }
}

class MoMoPayment implements PaymentState {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ qua MoMo.");
    }
}

class Order {
    private PaymentState paymentState;

    public Order(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public void processPayment(double amount) {
        paymentState.pay(amount);
    }
}

public class BaiTap01 {
    public static void main(String[] args) {
        Order order = new Order(new CashPayment());
        order.processPayment(500000);

        order.setPaymentState(new MoMoPayment());
        order.processPayment(300000);

        order.setPaymentState(new BankTransferPayment());
        order.processPayment(500000);
    }
}
