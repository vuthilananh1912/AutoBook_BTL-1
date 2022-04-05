package com.vtlallklmc.autobook_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vtlallklmc.autobook_btl.Main_Fragments.MainActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtsdt, edtPass;
    CheckBox cBLuuMK;
    Button btnDN;
    TextView txtViewDK, txtViewQuenMK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtsdt = (EditText) findViewById(R.id.edtsdt);
        edtPass = (EditText) findViewById(R.id.edtPass);
        cBLuuMK = (CheckBox) findViewById(R.id.cBLuuMK);
        btnDN = (Button) findViewById(R.id.btnDN);
        txtViewDK = (TextView) findViewById(R.id.txtViewDK);
        txtViewQuenMK = (TextView) findViewById(R.id.txtViewQuenMK);
    }

    public void rememberPass(String userName, String Pass, boolean status)
    {
        SharedPreferences sPref = getSharedPreferences( "User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        if(status == false)
        {
            editor.clear();
        }
        else {
            editor.putString("USERNAME", userName);
            editor.putString("PASSWORD", Pass);
            editor.putBoolean("REMEMBER", status);
        }
        editor.commit();
    }
    public int checkLogin(String u, String p)
    {
        if (u.equals("admin") && p.equals("admin"))
        {
            return 1;
        }else
        {
            return 01;
        }
    }

    String strU, strP;
    public void checkLogin( View view){
        strU = edtsdt.getText().toString();
        strP = edtPass.getText().toString();
        if (strU.isEmpty() || strP.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "U, P khong duoc de trong",
                    Toast.LENGTH_LONG).show();
        }else {
            if (checkLogin(strU, strP)>0)
            {
                Toast.makeText(getApplicationContext(), "Login thanh cong",
                        Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent( getApplicationContext(), MainActivity.class));
                    }
                }, 2000);
            }
        }
    }

    public void savePass(View view){
        String userName = edtsdt.getText().toString();
        String Pass = edtPass.getText().toString();
        boolean status = cBLuuMK.isChecked();
        rememberPass(userName, Pass, status);
    }
    public void register(View view){
        Intent intent = new Intent( this, Register.class);
        startActivity(intent);
        finish();
    }

}