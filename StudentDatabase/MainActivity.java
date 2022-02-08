package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name, usn, sem;
    Button insert, load;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        usn = findViewById(R.id.usn);
        sem = findViewById(R.id.sem);
        res = findViewById(R.id.res);
        insert = findViewById(R.id.insert);
        load = findViewById(R.id.load);

        DB db = new DB(getApplicationContext());

        insert.setOnClickListener(v -> {
            String n = name.getText().toString();
            String u = usn.getText().toString();
            int s = Integer.parseInt(sem.getText().toString());
            db.insert(n, u, s);
        });

        load.setOnClickListener(v -> res.setText(db.load()));

    }
}