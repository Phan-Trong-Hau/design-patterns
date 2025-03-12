package org.DecoratorPattern;

interface SalaryComponent {
    double calculateSalary();
    String getDescription();
}

class BasicSalary implements SalaryComponent {
    private double base;

    public BasicSalary(double base) {
        this.base = base;
    }

    @Override
    public double calculateSalary() {
        return base;
    }

    @Override
    public String getDescription() {
        return String.format("Lương cơ bản: %,d VND", (long) base);
    }
}

abstract class AllowanceDecorator implements SalaryComponent {
    protected SalaryComponent salaryComponent;

    public AllowanceDecorator(SalaryComponent salaryComponent) {
        this.salaryComponent = salaryComponent;
    }
}

class TPAllowance extends AllowanceDecorator {
    public TPAllowance(SalaryComponent salaryComponent) {
        super(salaryComponent);
    }

    @Override
    public double calculateSalary() {
        return salaryComponent.calculateSalary() + 5_000_000;
    }

    @Override
    public String getDescription() {
        return salaryComponent.getDescription() + String.format("\nPhụ cấp Trưởng phòng: +%,d VND", 5_000_000);
    }
}

class HTAllowance extends AllowanceDecorator {
    public HTAllowance(SalaryComponent salaryComponent) {
        super(salaryComponent);
    }

    @Override
    public double calculateSalary() {
        return salaryComponent.calculateSalary() + 7_000_000;
    }

    @Override
    public String getDescription() {
        return salaryComponent.getDescription() + String.format("\nPhụ cấp Hiệu trưởng: +%,d VND", 7_000_000);
    }
}

public class BaiTap02 {
    public static void main(String[] args) {
        SalaryComponent salary = new BasicSalary(10_000_000);
        System.out.println("---- Lương nhân viên ----");
        System.out.println(salary.getDescription());
        System.out.println("Tổng lương: " + String.format("%,d VND", (long) salary.calculateSalary()) + "\n");

        salary = new TPAllowance(salary);
        System.out.println("---- Lương Trưởng phòng ----");
        System.out.println(salary.getDescription());
        System.out.println("Tổng lương: " + String.format("%,d VND", (long) salary.calculateSalary()) + "\n");

        salary = new HTAllowance(salary);
        System.out.println("---- Lương Hiệu trưởng ----");
        System.out.println(salary.getDescription());
        System.out.println("Tổng lương: " + String.format("%,d VND", (long) salary.calculateSalary()));
    }
}
