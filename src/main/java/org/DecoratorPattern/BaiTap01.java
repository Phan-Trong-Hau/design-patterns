package org.DecoratorPattern;

interface Payment {
    void pay(double amount);
}

class BasePayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VNĐ.");
    }
}

class CashbackDecorator implements Payment {
    private Payment wrappedPayment;

    public CashbackDecorator(Payment wrappedPayment) {
        this.wrappedPayment = wrappedPayment;
    }

    @Override
    public void pay(double amount) {
        wrappedPayment.pay(amount);
        System.out.println("Hoàn lại " + (amount * 0.05) + " VNĐ vào ví điện tử.");
    }
}

class PointsRewardDecorator implements Payment {
    private Payment wrappedPayment;

    public PointsRewardDecorator(Payment wrappedPayment) {
        this.wrappedPayment = wrappedPayment;
    }

    @Override
    public void pay(double amount) {
        wrappedPayment.pay(amount);
        System.out.println("Nhận " + (amount / 10000) + " điểm thưởng.");
    }
}

public class BaiTap01 {
    public static void main(String[] args) {
        Payment payment = new CashbackDecorator(new PointsRewardDecorator(new BasePayment()));
        payment.pay(500000);
    }
}
