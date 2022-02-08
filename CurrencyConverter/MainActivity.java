package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1;
    TextView t1;
    Spinner s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        e1 = findViewById(R.id.e1);
        t1 = findViewById(R.id.t1);
        s1 = findViewById(R.id.s1);

        b1.setOnClickListener(v -> {
            double a = Double.parseDouble(e1.getText().toString());
            int pos = s1.getSelectedItemPosition();
            switch(pos) {
                case 1: t1.setText("" + (a / 70));
                break;
                case 2: t1.setText("" + (a * 70));
                break;
                default: t1.setText("Please select an option");
                break;
            }
        });

    }
}