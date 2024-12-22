package EmployeeManagementSystem;
import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(e -> e.employeeId == employeeId);
    }

    public void displayAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}


