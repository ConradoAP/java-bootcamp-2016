package com.Conrado.FinalProyect;

/**
 * Created by Narigon on 2/5/2016.
 */
public interface ShoppingCart {

    public void loadItems() throws Exception;

    public void findByName(String itemName) throws Exception;

    public void findByCategory(String itemCategory) throws Exception;

    public void showCart(String username) throws Exception;

    public void selectItems(String username, int Item_ID, int Quantity) throws Exception;

    public boolean cancelSelection(String username, int Item_ID, int Quantity) throws Exception;

    public void newCart(String username) throws Exception;

    public double endPurchase(String username) throws Exception;
}
