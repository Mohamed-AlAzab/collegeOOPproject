package EmployeeManagementSystem;

public abstract class Employee {
    protected int employeeId;
    protected String name;
    protected double salary;

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateSalary();

    abstract String getRole();

    @Override
    public String toString() {
        return "ID: " + employeeId
                + "\nName: " + name
                + "\nRole: " + getRole()
                + "\nPay:  " + calculateSalary()
                + "\n";
    }
}