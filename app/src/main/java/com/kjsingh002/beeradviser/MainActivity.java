package com.kjsingh002.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner beerColors;
    private Button findBeer;
    private TextView display_brands;
    private BeerExpert beerExpert;
    private List<String> brands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beerColors = findViewById(R.id.beer_colors);
        findBeer = findViewById(R.id.find_beer);
        display_brands = findViewById(R.id.display_brands);
        beerExpert = new BeerExpert();
        brands = new ArrayList<>();
        findBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* This is my way of simplifying things

                display_brands.setText("");
                brands = beerExpert.getBrands(beerColors.getSelectedItem().toString());
                for (String brand: brands){
                    display_brands.append(brand + '\n');
                }

                 */

                // This is how book is doing
                brands = beerExpert.getBrands(beerColors.getSelectedItem().toString());
                StringBuilder builder = new StringBuilder();
                for (String brand:brands){
                    builder.append(brand).append("\n");
                }
                display_brands.setText(builder);

            }
        });
    }
}
