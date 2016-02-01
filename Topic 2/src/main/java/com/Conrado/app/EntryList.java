package com.Conrado.app;

/**
 * Created by Narigon on 1/27/2016.
 */
public class EntryList {

    private Entry root;

    public EntryList(){
        root = null;
    }

    public void add(Entry node){
        if (root == null){
            node.next = null;
            root = node;
        } else {
            if (getLength()<10) {
                node.next = root;
                root = node;
            } else {
                Entry last = root;
                for (int i=0;i<9;i++){
                    last = last.next;
                }
                node.next = root;
                root = node;
                last.next = null;
            }
        }
    }

    public void delete(int index){
        Entry search = root;
        if (index > 1) {
            Entry search2 = root.next;
            for (int i = 2; i < index; i++) {
                search = search.next;
                search2 = search2.next;
            }
            search.next = search2.next;
        } else {
            root = root.next;
        }
    }

    public Entry get(int index){
        Entry search = root;
        for (int i=0; i<index; i++){
            search = search.next;
        }
        return search;
    }

    public int getLength(){
        Entry count = root;
        int q = 0;
        while (count.next != null){
            q ++;
            count = count.next;
        }
        return q;
    }
}
