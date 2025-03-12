package org.StrategyPattern;

interface SalaryStrategy {
    double calculateSalary(double baseSalary);
}

class BasicSalary implements SalaryStrategy {
    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary;
    }
}

class ManagerSalaryStrategy implements SalaryStrategy {
    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary + 500;
    }
}

class DirectorSalaryStrategy implements SalaryStrategy {
    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary + 1000;
    }
}

class EmployeeFixed {
    private String name;
    private double baseSalary;
    private SalaryStrategy salaryStrategy;

    public EmployeeFixed(String name, double baseSalary, SalaryStrategy salaryStrategy) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.salaryStrategy = salaryStrategy;
    }

    public void printSalary() {
        System.out.println(name + " : Lương = " + salaryStrategy.calculateSalary(baseSalary));
    }
}

public class BaiTap02 {
    public static void main(String[] args) {
        EmployeeFixed nv1 = new EmployeeFixed("Trần Văn A", 1000, new BasicSalary());
        nv1.printSalary();

        EmployeeFixed nv2 = new EmployeeFixed("Trần Văn B", 2000, new ManagerSalaryStrategy());
        nv2.printSalary();

        EmployeeFixed nv3 = new EmployeeFixed("Trần Văn C", 3000, new DirectorSalaryStrategy());
        nv3.printSalary();
    }
}
