package ReservationManagementSystem;

public interface ReservationService {
    void makeReservation(Table table, String customerName, String time);

    void cancelReservation(Table table);
}
