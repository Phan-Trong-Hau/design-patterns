package org.StatePattern;

interface SalaryState {
    double calculateSalary(double baseSalary);
}

class EmployeeSalary implements SalaryState {
    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary;
    }
}

class ManagerSalary implements SalaryState {
    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary + 5000000; // Phụ cấp Trưởng Phòng
    }
}

class DirectorSalary implements SalaryState {
    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary + 10000000; // Phụ cấp Giám đốc
    }
}

class Employee {
    private String name;
    private double baseSalary;
    private SalaryState salaryState;

    public Employee(String name, double baseSalary, SalaryState salaryState) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.salaryState = salaryState;
    }

    public void setSalaryState(SalaryState salaryState) {
        this.salaryState = salaryState;
    }

    public void printSalary() {
        System.out.println(name + " : Lương = " + salaryState.calculateSalary(baseSalary));
    }
}

public class BaiTap02 {
    public static void main(String[] args) {
        Employee nv1 = new Employee("Nguyễn Văn A", 100000, new EmployeeSalary());
        nv1.printSalary();

        nv1.setSalaryState(new ManagerSalary());
        nv1.printSalary();
    }
}
