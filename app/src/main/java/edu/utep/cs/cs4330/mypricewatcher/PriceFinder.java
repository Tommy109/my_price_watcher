/**
 * <h1>Price Finder</h1>
 *
 * <p>Price Finder gets a price from given URL (for now it is randomized with any URL)
 * A subclass Item is used to store values of interest; name, price, and url link of an item</p>
 *
 * @author Tomas Chagoya
 * @version 1.0
 * @since 2019-09-30
 */

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


