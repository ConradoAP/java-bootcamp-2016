package com.Conrado.ShopingCart;

/**
 * Created by Narigon on 1/21/2016.
 */
public class ShoppingCartImp implements ShoppingCart, UserCRUD {

    DataList list = new DataList();

    public void loadItems(){
        MockDatabase database = new MockDatabase();
        int size = database.getLength();
        for (int i=1 ; i<=size ; i++){
            Data data = new Data();
            data.setItem(database.getItems(i));
            data.setPrice(database.getPrice(i));
            System.out.println(i+": "+data.item+" costs $"+data.price);
            list.add(data);
        }
    }

    public void selectItems(int index){
        int itemIndex = index - 1;
        Data data;
        data = list.get(itemIndex);
        data.addQuantity();
    }

    public void cancelSelection(int index){
        int itemIndex = index - 1;
        Data data;
        data = list.get(itemIndex);
        data.substractQuantity();
    }

    public void create(String item, double price){
        Data data = new Data();
        data.setItem(item);
        data.setPrice(price);
        list.add(data);
    }

    public void read(){
        int length = list.getLength();
        Data data;
        for (int i=0; i<length; i++){
            data = list.get(i);
            System.out.println(i+": "+data.item+" costs $"+data.price);
        }
    }

    /**
     * The update method doesn't do anything in this case because i'm using a "Mock" Database.
     * If I was using a real Database, the update method would load the new database's items ("loadItems" method).
     * The "create" method would add information to the real Database.
     * The "delete" method would erase information from the real Database.
      */

    public void update(){
        System.out.println("The Item list have been updated");
    }

    public void delete(int index){
        Data data1;
        Data data2;
        if (index > 0){
            data1 = list.get(index - 1);
            data2 = list.get(index + 1);
            data1.next = data2;
        } else {
            list.deleteRoot();
        }
    }

    public void endPurchase(){
        int size = list.getLength();
        double fullPrice = 0;
        for (int f=0; f<size; f++){
            Data data2 = list.get(f);
            fullPrice = fullPrice + data2.price;
            System.out.println("bought: "+data2.item+"s");
        }
        System.out.println("Total amount to pay: $"+fullPrice);
    }
}
