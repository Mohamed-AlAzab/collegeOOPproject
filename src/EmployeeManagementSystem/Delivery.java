package EmployeeManagementSystem;

public class Delivery extends Employee {
    private int ordersDelivered;
    private double payPerOrder;

    public Delivery(int employeeId, String name, int ordersDelivered, double payPerOrder) {
        super(employeeId, name, 0);
        this.ordersDelivered =ordersDelivered;
        this.payPerOrder =payPerOrder;
    }

    @Override
    double calculateSalary() {
        return ordersDelivered * payPerOrder;
    }

    @Override
    String getRole() {
        return "Delivery Person";
    }
}
