package edu.utep.cs.cs4330.mypricewatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private PriceFinder priceFinder;
    private PriceFinder.Item item;
    private DecimalFormat df = new DecimalFormat("#.00");

    private TextView name,initialPrice,currentPrice,percentChange,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        url = findViewById(R.id.url);
        initialPrice = findViewById(R.id.initialPrice);
        currentPrice = findViewById(R.id.currentPrice);
        percentChange = findViewById(R.id.percentChange);


        priceFinder = new PriceFinder();


        if(savedInstanceState != null){
            String name = savedInstanceState.getString("name");
            double price = savedInstanceState.getDouble("price");
            double currentPrice = savedInstanceState.getDouble("currentPrice");
            String url = savedInstanceState.getString("url");

            item = new PriceFinder.Item(name,price,url);

            this.currentPrice.setText(df.format(currentPrice));
            this.percentChange.setText(df.format(priceChange(price,currentPrice))+"%");

        }

        else{
            item = new PriceFinder.Item("My Item Name", 50.00, "https://wwww.google.com");
            this.currentPrice.setText("50.00");
            this.percentChange.setText(df.format(0.00)+"%");
        }


        this.name.setText(item.name);
        this.initialPrice.setText(df.format(item.price));
        this.url.setText(item.url);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("url", url.getText().toString());
        outState.putString("name",item.name);
        outState.putDouble("price", Double.parseDouble(initialPrice.getText().toString()));
        outState.putDouble("currentPrice", Double.parseDouble(currentPrice.getText().toString()));

    }

    public void updateClicked(View view){
        double updatedPrice = priceFinder.getPrice("https://www.google.com");
        double changePercent = priceChange(item.price, updatedPrice);


        initialPrice.setText(df.format(item.price));
        currentPrice.setText(df.format(updatedPrice));
        percentChange.setText(df.format(changePercent) + "%");

    }

    private double priceChange(double initial, double current){
        return ((current-initial)/initial)*100;
    }
}
