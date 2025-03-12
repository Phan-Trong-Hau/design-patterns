package org.StatePattern;

interface TableState {
    void handleRequest(Table table);
    String getColor();
}

class FreeState implements TableState {
    @Override
    public void handleRequest(Table table) {
        System.out.println("🔄 Chuyển sang trạng thái Đã đặt (Ordered)");
        table.setState(new OrderedState());
    }

    @Override
    public String getColor() {
        return "Trống (Màu XANH LÁ)";
    }
}

class OrderedState implements TableState {
    @Override
    public void handleRequest(Table table) {
        System.out.println("🔄 Chuyển sang trạng thái Hoàn thành (Done)");
        table.setState(new DoneState());
    }

    @Override
    public String getColor() {
        return "Đã đặt (Màu CAM)";
    }
}

class DoneState implements TableState {
    @Override
    public void handleRequest(Table table) {
        System.out.println("🔄 Chuyển về trạng thái Trống (Free)");
        table.setState(new FreeState());
    }

    @Override
    public String getColor() {
        return "Hoàn thành (Màu VÀNG)";
    }
}

class FixingState implements TableState {
    @Override
    public void handleRequest(Table table) {
        System.out.println("🔄 Chuyển sang trạng thái Hoàn thành (Done)");
        table.setState(new DoneState());
    }

    @Override
    public String getColor() {
        return "Đang sửa chữa (Màu ĐỎ)";
    }
}

class Table {
    private TableState currentState;

    public Table() {
        this.currentState = new FreeState();
    }

    public void setState(TableState state) {
        this.currentState = state;
    }

    public void handleRequest() {
        currentState.handleRequest(this);
    }

    public void showStatus() {
        System.out.println("ℹ️ Trạng thái hiện tại: " + currentState.getColor());
    }
}

public class BaiTap03 {
    public static void main(String[] args) {
        Table table = new Table();

        for (int i = 0; i < 4; i++) {
            table.showStatus();
            table.handleRequest();
            System.out.println("------------------------");
        }
    }
}
