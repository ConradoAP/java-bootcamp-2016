package com.Conrado.app;

/**
 * Created by Narigon on 1/27/2016.
 */
public class BlogSoftware {

    EntryList list = new EntryList();

    public void post(String text) {
        Entry entry = new Entry();
        entry.setEntry(text);
        if (list.getLength() < 9){
            list.add(entry);
        } else {
            list.delete(9);
            list.add(entry);
        }
    }

    public void delete(int index){
        list.delete(index);
    }

    public void show(){
        int length = list.getLength();
        for (int i=0; i<length; i++){
            Entry data = list.get(i);
            System.out.println(data.text);
        }
    }
}
