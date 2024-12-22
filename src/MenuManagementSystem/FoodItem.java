package MenuManagementSystem;

import java.util.Arrays;

public class FoodItem extends MenuItem {
    String[] ingredients;
    boolean isVegetarian;

    public FoodItem(String itemId, String itemName, double price, boolean available, String[] ingredients, boolean isVegetarian) {
        super(itemId, itemName, price, available);
        this.ingredients = ingredients;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public void displayDetails() {
        System.out.println(
            "\nFood : "
            + "\n\tId : " + getItemId()
            + "\n\tName : " + getItemName()
            + "\n\tPrice : " + getPrice()
            + "\n\tAvailable : " + isAvailable()
            + "\n\tIngredients : " + Arrays.toString(ingredients)
            + "\n\tVegetarian : " + isVegetarian
        );
    }
}
