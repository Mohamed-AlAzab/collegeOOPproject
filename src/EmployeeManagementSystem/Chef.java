package EmployeeManagementSystem;

public class Chef extends Employee {
    private double discount;

    public Chef(int employeeId, String name, double salary, double discount) {
        super(employeeId, name, salary);
        this.discount = discount;
    }

    @Override
    double calculateSalary() {
        return this.salary - discount;
    }

    @Override
    String getRole() {
        return "Chef";
    }
}
