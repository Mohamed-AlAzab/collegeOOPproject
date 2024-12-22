package MenuManagementSystem;

import java.util.ArrayList;

public class MenuManager {
    ArrayList<MenuItem> menuItems = new ArrayList<>();

    public MenuManager() {
        System.out.println("Menu is empty");
    }

    public MenuManager(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void removeItem(String itemId) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getItemId().equals(itemId)) {
                menuItems.remove(menuItem);
            }
        }
    }

    public void displayMenu() {
        for (MenuItem menuItem : menuItems) {
            menuItem.displayDetails();
        }
    }
}
