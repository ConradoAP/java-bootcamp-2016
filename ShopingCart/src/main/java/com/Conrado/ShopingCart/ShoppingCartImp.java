package com.Conrado.ShopingCart;

/**
 * Created by Narigon on 1/21/2016.
 */
public class ShoppingCartImp implements ShoppingCart {

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
        Data data1;
        data1 = list.get(itemIndex);
        data1.setQuantity();
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
