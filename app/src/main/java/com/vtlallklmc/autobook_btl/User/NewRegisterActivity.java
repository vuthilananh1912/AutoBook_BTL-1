package com.vtlallklmc.autobook_btl.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vtlallklmc.autobook_btl.Main_Fragments.MainActivity;
import com.vtlallklmc.autobook_btl.R;
import com.vtlallklmc.autobook_btl.UserID;

public class NewRegisterActivity extends AppCompatActivity {
    TextInputEditText edtFullname, edtPhoneRegister, edtMKRegister, edtMKRegister2;
    Button btnRegister;
    TextView txtLoginRegister;

    User user;
    UserDatabaseData userDatabaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);
        getView();
        userDatabaseData = new UserDatabaseData(NewRegisterActivity.this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = edtFullname.getText().toString(),
                        phone = edtPhoneRegister.getText().toString(),
                        mk = edtMKRegister.getText().toString(),
                        mk2 = edtMKRegister2.getText().toString();

                if(fullname.isEmpty() || phone.isEmpty() || mk.isEmpty() || mk2.isEmpty()){
                    Toast.makeText(NewRegisterActivity.this, "Không được để trống thông tin", Toast.LENGTH_LONG).show();
                }
                else if(mk.equals(mk2)==false){
                    Toast.makeText(NewRegisterActivity.this, "Mật khẩu nhập lại phải trùng mật khẩu ban đầu", Toast.LENGTH_SHORT).show();
                }else if(phone.startsWith("0")==false){
                    Toast.makeText(NewRegisterActivity.this, "Số điện thoại bắt buộc có 10 số và bắt đầu bằng 0...", Toast.LENGTH_SHORT).show();
                }else if(mk.length()<=6){
                    Toast.makeText(NewRegisterActivity.this, "Mật khẩu tối thiểu phải 6 kí tự", Toast.LENGTH_SHORT).show();
                }else if(userDatabaseData.checkExists(phone)==true){
                    Toast.makeText(NewRegisterActivity.this, "Đã đăng ký tài khoản khác với số điện thoại này", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(NewRegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    user = new User(fullname,phone,mk,null,null);
                    userDatabaseData.addUser(user);
                    UserID.ID = phone;

                    Intent registerToMain = new Intent(NewRegisterActivity.this, MainActivity.class);
                    startActivity(registerToMain);
                }
            }
        });
        txtLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void getView(){
        edtFullname = findViewById(R.id.edtFullname);
        edtPhoneRegister = findViewById(R.id.edtSDTRegister);
        edtMKRegister = findViewById(R.id.edtPasswordRegister);
        edtMKRegister2 = findViewById(R.id.edtPasswordRegister2);

        btnRegister = findViewById(R.id.btnRegister);
        txtLoginRegister = findViewById(R.id.txtViewDNTKKhac2);
    }
}