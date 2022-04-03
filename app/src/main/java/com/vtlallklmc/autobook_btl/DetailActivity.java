package com.vtlallklmc.autobook_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    DatabaseData databaseData;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent receivedIntent = getIntent();
        String mess = receivedIntent.getStringExtra("keyword");

        tvName = findViewById(R.id.tvName);

        databaseData = new DatabaseData(this);
        Car car = databaseData.searchCar(mess);
//        Toast.makeText(this, car.getName(), Toast.LENGTH_SHORT).show();
        tvName.setText(car.getName());
    }
}