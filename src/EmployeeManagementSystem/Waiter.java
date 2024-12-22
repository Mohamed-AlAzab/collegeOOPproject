package EmployeeManagementSystem;

public class Waiter extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    private double tips;

    public Waiter(int employeeId, String name, double tips, double hourlyRate,int hoursWorked) {
        super(employeeId, name, 0);
        this.hoursWorked =hoursWorked;
        this.hourlyRate =hourlyRate;
        this.tips = tips;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked + tips;
    }

    @Override
    String getRole() {
        return "Waiter";
    }
}


