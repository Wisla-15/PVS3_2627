package oop.inheritance;

import java.util.ArrayList;
import java.util.Collections;


public class ComparomgBasics {
    static void printList(ArrayList<Item> l){
            for(Item i : l){
                System.out.println(i.toString());
            }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("white monster",1000000,1.65));
        items.add(new Item("black monster",500000,1.65));
        items.add(new Item("white redbull",100000,2.));
        items.add(new Item("mango monster",250000,1.35));

//        printList(items);
        Collections.sort(items);
        printList(items);
    }
}

class Item implements Comparable<Item> {
    String name;
    int q;
    double price;

    public Item(String name, int q, double price) {
        this.name = name;
        this.q = q;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", q=" + q +
                ", price=" + price +
                '}';
    }

//    @Override
//    public int compareTo(Item o) {
//        return this.q - o.q;
//    }

    @Override
    public int compareTo(Item o) {
        return this.name.toUpperCase().compareTo(o.name.toUpperCase());
    }
}
