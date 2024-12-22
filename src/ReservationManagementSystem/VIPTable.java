package ReservationManagementSystem;

public class VIPTable extends Table {
    private boolean hasPrivateRoom;

    public VIPTable(int tableId, int capacity, boolean hasPrivateRoom) {
        super(tableId, capacity);
        this.hasPrivateRoom = hasPrivateRoom;
    }

    @Override
    public void displayDetails() {
        System.out.println("VIP ReservationManagementSystem.Table ID: " + tableId + ", Capacity: " + capacity +
                ", Private Room: " + hasPrivateRoom + ", Reserved: " + isReserved);
    }
}