/**
 * <h1>My Price Watcher</h1>
 *
 * <p>The My Price Watcher program implements an android application
 * that displays the information about a fixed item (intial price,
 * current price, change in percentage of price, and its name). One button is
 * used to change the price randomly and update the necessary infromation. An
 * URL link can be shared to the app.</p>
 *
 * @author Tomas Chagoya
 * @version 1.0
 * @since 2019-09-30
 */

package edu.utep.cs.cs4330.mypricewatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private PriceFinder.Item item;
    private DecimalFormat df = new DecimalFormat("#.00");

    private TextView initialPrice;
    private TextView currentPrice;
    private TextView percentChange;
    private TextView url;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         //Grab needed views
        this.name = findViewById(R.id.name);
        url = findViewById(R.id.url);
        initialPrice = findViewById(R.id.initialPrice);
        currentPrice = findViewById(R.id.currentPrice);
        percentChange = findViewById(R.id.percentChange);


         //If bundle has information stored, get that data and use it to populate
         //needed fields
        if(savedInstanceState != null){
            String name = savedInstanceState.getString("name");
            double price = savedInstanceState.getDouble("price");
            double currentPrice = savedInstanceState.getDouble("currentPrice");
            String url = savedInstanceState.getString("url");


            //create a new item with retrieved information
            item = new PriceFinder.Item(name,price,url);


            //calculate values for other views
            this.currentPrice.setText(df.format(currentPrice));
            this.percentChange.setText(df.format(percentChange(price,currentPrice))+"%");
        }



        //if nothing saved on bundle...
        else{
            String url = "";

            String action = getIntent().getAction();
            String type = getIntent().getType();


            //If another app is sharing text, use that as the url for item...
            if(Intent.ACTION_SEND.equalsIgnoreCase(action) &&
                    type != null && ("text/plain".equals(type))){
                url = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            }

            //...otherwise use default google.com
            if(url.isEmpty())
                url = "https://wwww.google.com";


            // create item with given information and set default values for fields
            item = new PriceFinder.Item("My Item Name", 50.00,url);
            this.currentPrice.setText("50.00");
            this.percentChange.setText(df.format(0.00)+"%");
        }

        //set the rest of the views with needed information
        name.setText(item.name);
        this.initialPrice.setText(df.format(item.price));
        this.url.setText(item.url);
    }

    /**
     * Overriden to save state when changing orientation of screen or pressing
     * back button. Does not save on pressing Home button on phone.
     * @param outState saved information of item: url,name,price.
     *                 Other information saved: current price of item.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("url", url.getText().toString());
        outState.putString("name",item.name);
        outState.putDouble("price", Double.parseDouble(initialPrice.getText().toString()));
        outState.putDouble("currentPrice", Double.parseDouble(currentPrice.getText().toString()));

    }

    /**
     * Fires when Button is clicked (Update Button). It gets and updated price, calculates
     * the percentage change with old price, and updates text views with updated values.
     * @param view The button that was clicked
     */
    public void updateClicked(View view){
        //get a random price
        double updatedPrice = new PriceFinder().getPrice("https://www.google.com");

        //calculate new value of percentage increased/decreased
        double changePercent = percentChange(item.price, updatedPrice);


        //update Views
        initialPrice.setText(df.format(item.price));
        currentPrice.setText(df.format(updatedPrice));
        percentChange.setText(df.format(changePercent) + "%");

    }

    /**
     * Calculates the percent change between an initial value and a new value
     * @param initial the original value
     * @param current the new value
     * @return double Returns the change as a percentage (positive or negative) out of 100%
     */
    private double percentChange(double initial, double current){
        return ((current-initial)/initial)*100;
    }
}
