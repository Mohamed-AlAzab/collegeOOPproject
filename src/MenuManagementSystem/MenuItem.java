package MenuManagementSystem;

public abstract class MenuItem {
    private String itemId;
    private String itemName;
    private double price;
    private boolean available;

    public MenuItem(String itemId, String itemName, double price, boolean available) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.available = available;
    }

    public void markAvailable() {
        this.available = true;
    }

    public void markUnavailable() {
        this.available = false;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    abstract public void displayDetails();
}
