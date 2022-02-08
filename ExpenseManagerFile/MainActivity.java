package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b1, b2;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.amount);
        e2 = findViewById(R.id.category);
        b1 = findViewById(R.id.insert);
        b2 = findViewById(R.id.load);
        res = findViewById(R.id.res);

        b1.setOnClickListener(v -> {
            String text = e1.getText().toString() + " " + e2.getText().toString();

            try {
                FileOutputStream fos =  openFileOutput("file.txt", MODE_APPEND);
                fos.write(text.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        b2.setOnClickListener(v -> {
           try {
               FileInputStream fis = openFileInput("file.txt");
               InputStreamReader isr = new InputStreamReader(fis);
               BufferedReader br = new BufferedReader(isr);
               StringBuilder sb = new StringBuilder();

               String text;
               while ((text = br.readLine()) != null) {
                   sb.append(text);
                   sb.append("\n");
               }

               res.setText(sb.toString());
           } catch (Exception e) {
               e.printStackTrace();
           }
        });

    }
}