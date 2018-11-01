package com.example.brianwawczak.currencyconverter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button convertCurrency = findViewById(R.id.idButton1);
        final EditText currencyToConvert = findViewById(R.id.idUserInput);
        final RadioButton rbUStoEuro = findViewById(R.id.idRadio1);
        final RadioButton rbEuroToUS = findViewById(R.id.idRadio2);
        final TextView displayResult = findViewById(R.id.idTextView);

        convertCurrency.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                DecimalFormat currency = new DecimalFormat("#.##");
                double dblUserInput = Double.parseDouble(currencyToConvert.getText().toString());
                double convertRate = 1.14;
                double convertedUserInput;
                if(rbUStoEuro.isChecked()){
                    if(dblUserInput <= 10000){
                        convertedUserInput = dblUserInput * convertRate;
                        displayResult.setText("€" + currency.format(convertedUserInput));

                    }
                    else{
                        Toast.makeText(MainActivity.this, "The value entered must be less than $10,000.00", Toast.LENGTH_LONG).show();
                    }
                }
                if(rbEuroToUS.isChecked()){
                    if(dblUserInput <= 10000){
                        convertedUserInput = dblUserInput / convertRate;
                        displayResult.setText(currency.format(convertedUserInput));

                    }
                    else{
                        Toast.makeText(MainActivity.this, "The value entered must be less than €10,000.00", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
