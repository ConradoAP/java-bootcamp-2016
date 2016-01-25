package com.Conrado.ShopingCart;

/**
 * Created by Narigon on 1/24/2016.
 */
public interface UserCRUD {
    public void create(String item, double price);
    public void read();
    public void update();
    public void delete(int index);
}
