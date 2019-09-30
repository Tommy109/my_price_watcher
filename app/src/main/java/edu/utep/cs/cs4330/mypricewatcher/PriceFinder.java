package edu.utep.cs.cs4330.mypricewatcher;

import java.util.Random;

public class PriceFinder {


    public double getPrice(String url){
        return new Random().nextDouble()*100;
    }

    public static class Item{
        String name;
        Double price;
        String url;

        public Item(String name, double price, String url){
            this.name = name;
            this.price = price;
            this.url = url;
        }
    }
}


