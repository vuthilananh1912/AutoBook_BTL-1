package com.vtlallklmc.autobook_btl.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.vtlallklmc.autobook_btl.R;

public class NewLoginActivity extends AppCompatActivity {
    TextInputEditText edtPhoneLogin, edtPasswordLogin;
    Button btnLogin;
    TextView tvRegisterLogin, tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);
    }

    public void getView(){
        edtPhoneLogin = findViewById(R.id.edtPhoneLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);

        btnLogin = findViewById(R.id.btnLogin);

        tvRegisterLogin = findViewById(R.id.txtRegister);
        tvForgotPassword = findViewById(R.id.txtForgotPass);
    }
}