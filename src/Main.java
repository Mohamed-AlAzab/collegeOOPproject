import AccountingManagementSystem.AccountingManager;
import EmployeeManagementSystem.*;
import MenuManagementSystem.FoodItem;
import MenuManagementSystem.MenuManager;
import ReservationManagementSystem.RegularTable;
import ReservationManagementSystem.ReservationManager;
import ReservationManagementSystem.VIPTable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReservationManager reservationManager = new ReservationManager();
        MenuManager menuManager = new MenuManager();
        EmployeeManager employeeManager = new EmployeeManager();
        AccountingManager accountingManager = new AccountingManager();

        RegularTable table1 = new RegularTable(1, 4, true);
        VIPTable table2 = new VIPTable(2, 8, true);

        reservationManager.addTable(table1);
        reservationManager.addTable(table2);

        Waiter employee1 = new Waiter(101, "John", 5000.0, 500.0, 140);
        Chef employee2 = new Chef(102, "Sarah", 7000, 500);

        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);

        menuManager.addItem(new FoodItem(
                "1025", "Burger", 70, true,
                new String[] {"bread", "meat patty", "lettuce", "tomato", "cheese", "onions"},
                false
        ));
        menuManager.addItem(new FoodItem(
                "1026", "Pasta", 60, true,
                new String[] {"pasta", "tomato sauce", "garlic", "olive oil", "cheese", "basil"},
                true
        ));
        menuManager.addItem(new FoodItem(
                "1027", "Pizza", 100, true,
                new String[] {"bread dough", "tomato sauce", "cheese", "pepperoni", "bell peppers", "olives"},
                false
        ));

        while (true) {
            System.out.println("Welcome! Are you a User or an Admin? (Type 'User' or 'Admin'):");
            String role = scanner.nextLine().trim().toLowerCase();

            if (role.equals("user")) {
                userActions(scanner, reservationManager);
            } else if (role.equals("admin")) {
                adminActions(scanner, reservationManager, menuManager, employeeManager, accountingManager);
            } else {
                System.out.println("Invalid role. Exiting the program.");
                break;
            }
        }

        scanner.close();
    }

    private static void userActions(Scanner scanner, ReservationManager reservationManager) {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. View Available Tables");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter table ID: ");
                    int tableId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter reservation time: ");
                    String time = scanner.nextLine();
                    reservationManager.makeReservation(reservationManager.getTableById(tableId), name, time);
                    break;
                case 2:
                    System.out.print("Enter table ID to cancel reservation: ");
                    tableId = scanner.nextInt();
                    reservationManager.cancelReservation(reservationManager.getTableById(tableId));
                    break;
                case 3:
                    reservationManager.displayTables();
                    break;
                case 4:
                    System.out.println("Exiting User Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminActions(Scanner scanner, ReservationManager reservationManager, MenuManager menuManager, EmployeeManager employeeManager, AccountingManager accountingManager) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Manage Reservations");
            System.out.println("2. Manage Menu");
            System.out.println("3. Manage Employees");
            System.out.println("4. Manage Accounting");
            System.out.println("5. Exit to Role Selection");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageReservations(scanner, reservationManager);
                    break;
                case 2:
                    manageMenu(scanner, menuManager);
                    break;
                case 3:
                    manageEmployees(scanner, employeeManager);
                    break;
                case 4:
                    manageAccounting(scanner, accountingManager);
                    break;
                case 5:
                    System.out.println("Exiting Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageMenu(Scanner scanner, MenuManager menuManager) {
        while (true) {
            System.out.println("\n--- Manage Menu ---");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Remove Menu Item");
            System.out.println("4. Back to Admin Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    menuManager.displayMenu();
                    break;
                case 2:
                    System.out.print("Enter item ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Is the item vegetarian? (true/false): ");
                    boolean isVegetarian = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter item ingredients (comma separated): ");
                    String[] ingredients = scanner.nextLine().split(",");
                    System.out.print("Is the item gluten-free? (true/false): ");
                    boolean isGlutenFree = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline

                    FoodItem newItem = new FoodItem(id, name, price, isVegetarian, ingredients, isGlutenFree);
                    menuManager.addItem(newItem);
                    System.out.println("Item added successfully.");
                    break;
                case 3:
                    System.out.print("Enter item ID to remove: ");
                    String removeId = scanner.nextLine();
                    menuManager.removeItem(removeId);
                    System.out.println("Item removed successfully.");
                    break;
                case 4:
                    System.out.println("Returning to Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageReservations(Scanner scanner, ReservationManager reservationManager) {
        while (true) {
            System.out.println("\n--- Manage Reservations ---");
            System.out.println("1. View All Reservations");
            System.out.println("2. Add New Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Check Table Availability");
            System.out.println("5. Back to Admin Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reservationManager.displayTables();
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter reservation time: ");
                    String reservationTime = scanner.nextLine();
                    System.out.print("Enter table ID: ");
                    int tableId = scanner.nextInt();
                    scanner.nextLine();
                    reservationManager.makeReservation(reservationManager.getTableById(tableId), customerName, reservationTime);
                    System.out.println("Reservation added successfully.");
                    break;
                case 3:
                    System.out.print("Enter table ID to cancel reservation: ");
                    int cancelTableId = scanner.nextInt();
                    scanner.nextLine();
                    reservationManager.cancelReservation(reservationManager.getTableById(cancelTableId));
                    System.out.println("Reservation canceled successfully.");
                    break;
                case 4:
                    reservationManager.displayTableAvailability();
                    break;
                case 5:
                    System.out.println("Returning to Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageEmployees(Scanner scanner, EmployeeManager employeeManager) {
        while (true) {
            System.out.println("\n--- Manage Employees ---");
            System.out.println("1. View All Employees");
            System.out.println("2. Add New Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Back to Admin Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    employeeManager.displayAllEmployees();
                    break;
                case 2:
                    System.out.println("Choose Employee Type:");
                    System.out.println("1. Manager");
                    System.out.println("2. Chef");
                    System.out.println("3. Waiter");
                    System.out.println("4. Delivery");
                    System.out.println("5. KitchenAssistant");
                    System.out.print("Enter your choice: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    double salary = 0;

                    Employee newEmployee = null;
                    switch (type) {
                        case 1:
                            System.out.print("Enter employee salary: ");
                            salary = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter employee bonus: ");
                            double bonus = scanner.nextDouble();
                            scanner.nextLine();
                            newEmployee = new Manager(employeeId, name, salary,bonus);
                            break;
                        case 2:
                            System.out.print("Enter employee salary: ");
                            salary = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter employee discount: ");
                            double discount = scanner.nextDouble();
                            scanner.nextLine();
                            newEmployee = new Chef(employeeId, name, salary,discount);
                            break;
                        case 3:
                            System.out.print("Enter the hourly rate: ");
                            double hourlyRate = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter the hours worked: ");
                            int hoursWorked = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter the tips: ");
                            int tips = scanner.nextInt();
                            scanner.nextLine();
                            newEmployee = new Waiter(employeeId, name, tips, hourlyRate, hoursWorked);
                            break;
                        case 4:
                            System.out.print("Enter the discount: ");
                            int ordersDelivered = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter the discount: ");
                            double payPerOrder = scanner.nextDouble();
                            scanner.nextLine();
                            newEmployee = new Delivery(employeeId, name, ordersDelivered, payPerOrder);
                            break;
                        case 5:
                            System.out.print("Enter employee discount: ");
                            hourlyRate = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter employee discount: ");
                            hoursWorked = scanner.nextInt();
                            scanner.nextLine();
                            newEmployee = new KitchenAssistant(employeeId, name ,hoursWorked, hourlyRate);
                            break;
                        default:
                            System.out.println("Invalid type. Employee not added.");
                            continue;
                    }
                    employeeManager.addEmployee(newEmployee);
                    System.out.println("Employee added successfully.");
                    break;
                case 3:
                    System.out.print("Enter employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    employeeManager.removeEmployee(removeId);
                    System.out.println("Employee removed successfully.");
                    break;
                case 4:
                    System.out.println("Returning to Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageAccounting(Scanner scanner, AccountingManager accountingManager) {
        while (true) {
            System.out.println("\n--- Manage Accounting ---");
            System.out.println("1. View Accounting Report");
            System.out.println("2. Record Income");
            System.out.println("3. Record Expense");
            System.out.println("4. Back to Admin Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    accountingManager.generateReport();
                    break;
                case 2:
                    System.out.print("Enter income amount: ");
                    double income = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter income description: ");
                    String incomeDescription = scanner.nextLine();
                    accountingManager.recordIncome(income, incomeDescription);
                    System.out.println("Income recorded successfully.");
                    break;
                case 3:
                    System.out.print("Enter expense amount: ");
                    double expense = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter expense description: ");
                    String expenseDescription = scanner.nextLine();
                    accountingManager.recordExpense(expense, expenseDescription);
                    System.out.println("Expense recorded successfully.");
                    break;
                case 4:
                    System.out.println("Returning to Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}