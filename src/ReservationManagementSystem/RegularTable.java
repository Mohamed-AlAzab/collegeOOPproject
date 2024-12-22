package ReservationManagementSystem;

public class RegularTable extends Table {
    private boolean nearWindow;

    public RegularTable(int tableId, int capacity, boolean nearWindow) {
        super(tableId, capacity);
        this.nearWindow = nearWindow;
    }

    @Override
    public void displayDetails() {
        System.out.println("Regular ReservationManagementSystem.Table ID: " + tableId + ", Capacity: " + capacity +
                ", Near Window: " + nearWindow + ", Reserved: " + isReserved);
    }
}