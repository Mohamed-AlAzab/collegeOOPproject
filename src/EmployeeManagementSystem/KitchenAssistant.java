package EmployeeManagementSystem;

public class KitchenAssistant extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public KitchenAssistant(int employeeId, String name, int hoursWorked, double hourlyRate) {
        super(employeeId, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    String getRole() {
        return "Kitchen Assistant";
    }
}
