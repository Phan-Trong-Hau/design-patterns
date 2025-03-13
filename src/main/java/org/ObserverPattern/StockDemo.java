package org.ObserverPattern;


import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Investor {
    void update(String stockName, double price);
}

// Concrete Observer
class ConcreteInvestor implements Investor {
    private String name;

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Investor " + name + " notified: " + stockName + " price changed to " + price);
    }
}

// Subject interface
interface Stock {
    void registerInvestor(Investor investor);
    void removeInvestor(Investor investor);
    void notifyInvestors();
}

// Concrete Subject
class ConcreteStock implements Stock {
    private String name;
    private double price;
    private List<Investor> investors = new ArrayList<>();

    public ConcreteStock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    @Override
    public void registerInvestor(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(name, price);
        }
    }
}

public class StockDemo {
    public static void main(String[] args) {
        ConcreteStock stockIUH = new ConcreteStock("IUH", 2.0);
        ConcreteStock stockPNJ = new ConcreteStock("PNJ", 2.0);

        Investor investor1 = new ConcreteInvestor("Thi Mau");
        Investor investor2 = new ConcreteInvestor("Van Cao");

        stockIUH.registerInvestor(investor1);
        stockIUH.registerInvestor(investor2);

        stockPNJ.registerInvestor(investor2);


        System.out.println("Initial stock price: " + 2.0);

        while (true) {

            double newPrice = 10 + Math.random() * 90;
            System.out.println("\nStock price changing...");
            stockIUH.setPrice(newPrice);
            stockPNJ.setPrice(newPrice + 3.715);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
