package org.DecoratorPattern;

interface Table {
    String getDescription();
    String getColor();
}

class BasicTable implements Table {
    @Override
    public String getDescription() {
        return "Bàn tiêu chuẩn";
    }

    @Override
    public String getColor() {
        return "Màu XÁM (Mặc định)";
    }
}

abstract class TableDecorator implements Table {
    protected Table decoratedTable;

    public TableDecorator(Table decoratedTable) {
        this.decoratedTable = decoratedTable;
    }

    @Override
    public String getDescription() {
        return decoratedTable.getDescription();
    }

    @Override
    public String getColor() {
        return decoratedTable.getColor();
    }
}

class FreeTable extends TableDecorator {
    public FreeTable(Table decoratedTable) {
        super(decoratedTable);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " - Trống";
    }

    @Override
    public String getColor() {
        return "Màu XANH LÁ";
    }
}

class OrderedTable extends TableDecorator {
    public OrderedTable(Table decoratedTable) {
        super(decoratedTable);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " - Đã đặt";
    }

    @Override
    public String getColor() {
        return "Màu CAM";
    }
}

class DoneTable extends TableDecorator {
    public DoneTable(Table decoratedTable) {
        super(decoratedTable);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " - Hoàn thành";
    }

    @Override
    public String getColor() {
        return "Màu VÀNG";
    }
}

class FixingTable extends TableDecorator {
    public FixingTable(Table decoratedTable) {
        super(decoratedTable);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " - Đang sửa chữa";
    }

    @Override
    public String getColor() {
        return "Màu ĐỎ";
    }
}

public class BaiTap03 {
    public static void main(String[] args) {
        Table table = new BasicTable();

        System.out.println(table.getDescription() + " | Màu: " + table.getColor());

        table = new FreeTable(table);
        System.out.println(table.getDescription() + " | Màu: " + table.getColor());

        table = new OrderedTable(table);
        System.out.println(table.getDescription() + " | Màu: " + table.getColor());

        table = new DoneTable(table);
        System.out.println(table.getDescription() + " | Màu: " + table.getColor());

        table = new FixingTable(table);
        System.out.println(table.getDescription() + " | Màu: " + table.getColor());
    }
}
