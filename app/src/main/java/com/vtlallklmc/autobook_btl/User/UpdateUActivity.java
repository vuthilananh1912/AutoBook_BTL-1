package com.vtlallklmc.autobook_btl.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vtlallklmc.autobook_btl.R;

public class UpdateUActivity extends AppCompatActivity {
    Button btnUpdate;
    EditText tvuname;

    UserDatabaseData userDatabaseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_update_uactivity);
        setContentView(R.layout.activity_update_uactivity);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        tvuname = (EditText) findViewById(R.id.tvuname);

        userDatabaseData=new UserDatabaseData(UpdateUActivity.this);
        Intent intent = getIntent();
        tvuname.setText( intent.getStringExtra("Name"));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = tvuname.getText().toString();
                userDatabaseData.UpdateUserName(intent.getStringExtra("Phone"), strUserName );
                //finish();
            }
        });
    }
}