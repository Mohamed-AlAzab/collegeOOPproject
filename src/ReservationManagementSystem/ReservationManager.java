package ReservationManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private List<Table> tables;

    public ReservationManager() {
        this.tables = new ArrayList<>();
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public Table getTableById(int tableId) {
        for (Table table : tables) {
            if (table.getTableId() == tableId) {
                return table;
            }
        }
        System.out.println("Table with ID " + tableId + " not found.");
        return null;
    }

    public void makeReservation(Table table, String name, String time) {
        if (table != null && !table.isReserved) {
            table.reserveTable();
            System.out.println("Reservation made for " + name + " at " + time + ".");
        } else if (table != null) {
            System.out.println("Table " + table.getTableId() + " is already reserved.");
        }
    }

    public void cancelReservation(Table table) {
        if (table != null && table.isReserved) {
            table.releaseTable();
            System.out.println("Reservation cancelled.");
        } else if (table != null) {
            System.out.println("Table " + table.getTableId() + " is not reserved.");
        }
    }

    public void displayTableAvailability() {
        System.out.println("\n--- Table Availability ---");
        for (Table table : tables) {
            if (!table.isReserved) {
                System.out.println("Table " + table.getTableId() + " (Capacity: " + table.capacity + ") is available.");
            }
        }
    }

    public void displayTables() {
        for (Table table : tables) {
            table.displayDetails();
        }
    }
}
