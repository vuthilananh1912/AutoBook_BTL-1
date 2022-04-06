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

public class Register extends AppCompatActivity {

    EditText edtName, edtNameDN, edtSdtDK, edtPassDK;
    CheckBox cBLuuMKDK;
    Button btnDK;
    TextView txtViewDNTKKhac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = (EditText) findViewById(R.id.edtName);
        edtNameDN = (EditText) findViewById(R.id.edtNameDN);
        edtSdtDK = (EditText) findViewById(R.id.edtSdtDK);
        edtPassDK = (EditText) findViewById(R.id.edtPassDK);
        cBLuuMKDK = (CheckBox) findViewById(R.id.cBLuuMKDK);
        btnDK = (Button) findViewById(R.id.btnDK);
        txtViewDNTKKhac = (TextView) findViewById(R.id.txtViewDNTKKhac);
    }

    public void rememberPass(String userName, String Pass, boolean status) {
        SharedPreferences sPref = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        if (status == false) {
            editor.clear();
        } else {
            editor.putString("USERNAME", userName);
            editor.putString("PASSWORD", Pass);
            editor.putBoolean("REMEMBER", status);
        }
        editor.commit();
    }

    public int checkRegistration(String N, String NDN, String SdtDK, String PassDK) {
        if (N.equals("admin") && NDN.equals("admin") && SdtDK.equals("admin") && PassDK.equals("admin")) {
            return 1;
        } else {
            return 0; //trước kia code của LAnk là 01: không biết có nhầm k :v
        }
    }

    String strN, strNDN, strSdtDK, strPassDK;

    public void checkRegistration(View view) {
        strN = edtName.getText().toString();
        strNDN = edtNameDN.getText().toString();
        strSdtDK = edtSdtDK.getText().toString();
        strPassDK = edtPassDK.getText().toString();

        if ( strN.isEmpty() || strNDN.isEmpty() || strSdtDK.isEmpty() || strPassDK.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Không được để trống thông tin",
                    Toast.LENGTH_LONG).show();
        } else if (checkRegistration(strN, strNDN, strSdtDK, strPassDK )>0)
        {
            Toast.makeText(getApplicationContext(), "Đăng ký thành công",
                    Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
            }, 2000);
        }

    }

    public void savePass(View view) {
        String userName = edtSdtDK.getText().toString();
        String Pass = edtPassDK.getText().toString();
        boolean status = cBLuuMKDK.isChecked();
        rememberPass(userName, Pass, status);
    }

    public void quayveDN(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}