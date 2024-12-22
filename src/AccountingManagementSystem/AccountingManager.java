package AccountingManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class AccountingManager implements AccountingService {

    private double totalIncome = 0.0;
    private double totalExpenses = 0.0;
    private List<String> transactions = new ArrayList<>();

    @Override
    public void recordIncome(double amount, String description) {
        totalIncome += amount;
        transactions.add("Income: " + description + " - $" + amount);
        System.out.println("Income recorded: " + description + " - $" + amount);
    }

    @Override
    public void recordExpense(double amount, String description) {
        totalExpenses += amount;
        transactions.add("Expense: " + description + " - $" + amount);
        System.out.println("Expense recorded: " + description + " - $" + amount);
    }

    @Override
    public void generateReport() {
        System.out.println("\n--- Genral Report ---");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Net Balance: $" + (totalIncome - totalExpenses));
        System.out.println("\nTransactions:");
        System.out.println(transactions);
    }
}
