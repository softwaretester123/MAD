package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton r1, r2, r3, r4;
    Button b1;
    EditText e1;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);

        b1 = findViewById(R.id.b1);

        e1 = findViewById(R.id.e1);
        res = findViewById(R.id.res);

        b1.setOnClickListener(v -> {
            double a = Double.parseDouble(e1.getText().toString());
            double ans;

            if (r1.isChecked()) {
                res.setText("" + (a / 100) + " M");
            } else if (r2.isChecked()) {
                res.setText("" + (a * 100) + " CM");
            } else if (r3.isChecked()) {
                res.setText("" + (a * 12) + " INCH");
            } else if (r4.isChecked()) {
                res.setText("" + (a / 12) + " FEET");
            } else {
                res.setText("Please select an option");
            }

        });


    }
}