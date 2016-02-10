package com.Conrado.FinalProyect;

/**
 * Created by Narigon on 2/5/2016.
 */
public interface ShoppingCart {

    public void loadItems();

    public void findByName(String itemName);

    public void findByCategory(String itemCategory);

    public void showCart(String username);

    public void selectItems(String username, int Item_ID, int Quantity);

    public void cancelSelection(String username, int Item_ID, int Quantity);

    public void newCart(String username);

    public double endPurchase(String username);
}
