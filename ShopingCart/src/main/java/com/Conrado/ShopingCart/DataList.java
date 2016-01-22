package com.Conrado.ShopingCart;

/**
 * Created by Narigon on 1/21/2016.
 */
public class DataList {

    private Data root;

    public DataList(){
        root = null;
    }

    public void add(Data data){
        if (root == null){
            data.next = null;
            root = data;
        } else {
            data.next = root;
            root = data;
        }
    }

    public Data get(int index){
        Data search = root;
        for (int i=0; i<index; i++){
            search = search.next;
        }
        return search;
    }

    public int getLength(){
        Data count = root;
        int q = 0;
        while (count.next != null){
            q ++;
            count = count.next;
        }
        return q;
    }
}
