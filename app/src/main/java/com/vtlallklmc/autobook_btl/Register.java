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
import com.vtlallklmc.autobook_btl.User.User;
import com.vtlallklmc.autobook_btl.User.UserDatabaseData;

//TÔI NGHĨ TÔI SẼ CODE LẠI ĐĂNG KÝ ĐĂNG NHẬP :(
public class Register extends AppCompatActivity {

    EditText edtName, edtSdtDK, edtPassDK, edtPassDK2;
    CheckBox cBLuuMKDK;
    Button btnDK;
    TextView txtViewDNTKKhac;

    User newUser;

    private String phoneUser = "";

    UserDatabaseData userDatabaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = (EditText) findViewById(R.id.edtName);
//        edtNameDN = (EditText) findViewById(R.id.edtNameDN);
        edtSdtDK = (EditText) findViewById(R.id.edtSdtDK);
        edtPassDK = (EditText) findViewById(R.id.edtPassDK);
        edtPassDK2 = (EditText) findViewById(R.id.edtPassDK2);
//        cBLuuMKDK = (CheckBox) findViewById(R.id.cBLuuMKDK);
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

    public int checkRegistration(String N, String NDN, String SdtDK, String PassDK, String PassDK2) {
        if (N.equals("admin") && NDN.equals("admin") && SdtDK.equals("admin") && PassDK.equals("admin")) {
            return 1;
        } else {
            return 0; //trước kia code của LAnk là 01: không biết có nhầm k :v
        }
    }

    String strN, strSdtDK, strPassDK, strPassDK2;

    public void checkRegistration(View view) {
        strN = edtName.getText().toString();
//        strNDN = edtNameDN.getText().toString();
        strSdtDK = edtSdtDK.getText().toString();
        strPassDK = edtPassDK.getText().toString();
        strPassDK2 = edtPassDK2.getText().toString();


        if ( strN.isEmpty() || strSdtDK.isEmpty() || strPassDK.isEmpty() || strPassDK2.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Không được để trống thông tin",
                    Toast.LENGTH_LONG).show();
        } else if (checkRegistration(strN, strSdtDK, strPassDK, strPassDK2, strPassDK2)>0)
        {
            Toast.makeText(getApplicationContext(), "Đăng ký thành công",
                    Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    newUser = new User(strN,strSdtDK,strPassDK,null,null);
                    userDatabaseData.addUser(newUser);
                    phoneUser = strSdtDK;
                    Intent registerToMainIntent =  new Intent(getApplicationContext(), MainActivity.class);
                    registerToMainIntent.putExtra("phoneUser",phoneUser);
                    startActivity(registerToMainIntent);
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
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();

    }
}