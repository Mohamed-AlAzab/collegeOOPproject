package EmployeeManagementSystem;

public class Manager extends Employee {
    private double bonus;

    public Manager(int employeeId, String name, double salary, double bonus) {
        super(employeeId, name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return this.salary + bonus;
    }

    @Override
    String getRole() {
        return "Manager";
    }
}
