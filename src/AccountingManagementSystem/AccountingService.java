package AccountingManagementSystem;

public interface AccountingService {
    void recordIncome(double amount, String description);
    void recordExpense(double amount, String description);
    void generateReport();
}