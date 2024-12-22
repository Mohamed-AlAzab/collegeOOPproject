package ReservationManagementSystem;

import java.util.ArrayList;
import java.util.List;

abstract class Table {
    protected int tableId;
    protected int capacity;
    protected boolean isReserved;

    public Table(int tableId, int capacity) {
        this.tableId = tableId;
        this.capacity = capacity;
        this.isReserved = false;
    }

    public void reserveTable() {
        isReserved = true;
        System.out.println("ReservationManagementSystem.Table " + tableId + " reserved.");
    }

    public void releaseTable() {
        isReserved = false;
        System.out.println("ReservationManagementSystem.Table " + tableId + " is now available.");
    }

    public abstract void displayDetails();

    public int getTableId() {
        return tableId;
    }
}