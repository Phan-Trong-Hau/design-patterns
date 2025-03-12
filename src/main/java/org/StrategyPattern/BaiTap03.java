package org.StrategyPattern;

interface TableStrategy {
    String getColor();
}

class FreeStrategy implements TableStrategy {
    @Override
    public String getColor() {
        return "Trống (Màu XANH LÁ)";
    }
}

class OrderedStrategy implements TableStrategy {
    @Override
    public String getColor() {
        return "Đã đặt (Màu CAM)";
    }
}

class DoneStrategy implements TableStrategy {
    @Override
    public String getColor() {
        return "Hoàn thành (Màu VÀNG)";
    }
}

class FixingStrategy implements TableStrategy {
    @Override
    public String getColor() {
        return "Đang sửa chữa (Màu ĐỎ)";
    }
}

class Table {
    private TableStrategy strategy;

    public Table(TableStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TableStrategy strategy) {
        this.strategy = strategy;
    }

    public void showStatus() {
        System.out.println("ℹ️ Trạng thái hiện tại: " + strategy.getColor());
    }
}

public class BaiTap03 {
    public static void main(String[] args) {
        Table table = new Table(new FreeStrategy());

        table.showStatus();
        table.setStrategy(new OrderedStrategy());
        table.showStatus();
        table.setStrategy(new DoneStrategy());
        table.showStatus();
        table.setStrategy(new FixingStrategy());
        table.showStatus();
    }
}
