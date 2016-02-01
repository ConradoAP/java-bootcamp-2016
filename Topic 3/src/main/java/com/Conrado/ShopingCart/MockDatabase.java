package com.Conrado.ShopingCart;

/**
 * Created by Narigon on 1/21/2016.
 */
public class MockDatabase {


    public String getItems(int n) {
        String item = null;
        if (n < 4 && n > 0) {
            switch (n) {
                case 1:
                    item = "Shirt";
                    break;
                case 2:
                    item = "Jeans";
                    break;
                default:
                    item = "Jacket";
            }
        } else {
            System.out.println("Input out of parameters");
        }
        return item;
    }

    public double getPrice(int m){
        double price = 0;
        if (m < 4 && m > 0) {
            switch (m) {
                case 1:
                    price = 20.6;
                    break;
                case 2:
                    price = 45.2;
                    break;
                default:
                    price = 62.5;
            }
        } else {
            System.out.println("Input out of parameters");
        }
        return price;
    }

    public int getLength(){
        return 3;
    }
}
