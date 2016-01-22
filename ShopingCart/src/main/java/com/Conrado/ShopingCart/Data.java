package com.Conrado.ShopingCart;

/**
 * Created by Narigon on 1/21/2016.
 */
public class Data {
    String item;
    double price;
    int quantity;
    Data next;

    public Data(){
        quantity = 0;
    }

    public void setItem(String i) {
        this.item = i;
    }

    public void setPrice(double n){
        this.price = n;
    }

    public void setQuantity(){
        this.quantity = quantity + 1;
    }
}
