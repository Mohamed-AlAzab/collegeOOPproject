package MenuManagementSystem;

public class DrinkableItem extends MenuItem {
    private double size;

    public DrinkableItem(String itemId, String itemName, double price, boolean available, double size) {
        super(itemId, itemName, price, available);
        this.size = size;
    }

    @Override
    public void displayDetails() {
        System.out.println(
            "\nDrink : "
            + "\n\tId : " + getItemId()
            + "\n\tName : " + getItemName()
            + "\n\tPrice : " + getPrice()
            + "\n\tAvailable : " + isAvailable()
            + "\n\tSize : " + size
        );
    }
}
