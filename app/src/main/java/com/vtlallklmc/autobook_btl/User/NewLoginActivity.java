package com.vtlallklmc.autobook_btl.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vtlallklmc.autobook_btl.LoginActivity;
import com.vtlallklmc.autobook_btl.Main_Fragments.MainActivity;
import com.vtlallklmc.autobook_btl.R;
import com.vtlallklmc.autobook_btl.UserID;

public class NewLoginActivity extends AppCompatActivity {
    TextInputEditText edtPhoneLogin, edtPasswordLogin;
    Button btnLogin;
    TextView tvRegisterLogin, tvForgotPassword;
    //private long backPressTime; //thời gian chờ nhấn nút back 2 lần liên tiếp

    UserDatabaseData userDatabaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);
        getView();
        userDatabaseData = new UserDatabaseData(NewLoginActivity.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = edtPhoneLogin.getText().toString(),
                        mk = edtPasswordLogin.getText().toString();
                if (sdt.isEmpty() || mk.isEmpty()) {
                    Toast.makeText(NewLoginActivity.this, "Không được để trống thông tin", Toast.LENGTH_LONG).show();
                } else if (sdt.startsWith("0") == false) {
                    Toast.makeText(NewLoginActivity.this, "Số điện thoại bắt buộc có 10 số và bắt đầu bằng 0...", Toast.LENGTH_SHORT).show();
                } else if (mk.length() <= 6) {
                    Toast.makeText(NewLoginActivity.this, "Mật khẩu tối thiểu phải 6 kí tự", Toast.LENGTH_SHORT).show();
                } else if (userDatabaseData.checkExists(sdt) == true && userDatabaseData.findUserLogin(sdt).getPassword().toString().equals(mk) == true) {
                    Toast.makeText(NewLoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    UserID.ID = sdt;

                    Intent loginToMain = new Intent(NewLoginActivity.this, MainActivity.class);
                    startActivity(loginToMain);
                    edtPasswordLogin.setText("");
                    edtPasswordLogin.clearFocus();
                } else {
                    Toast.makeText(NewLoginActivity.this, "Sai số điện thoại hoặc mật khẩu. Nếu chưa có, hãy đăng ký", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginToRegister = new Intent(NewLoginActivity.this, NewRegisterActivity.class);
                startActivity(loginToRegister);
            }
        });
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NewLoginActivity.this, "Giải lao, làm 1 việc gì đó sẽ giúp bạn nhớ ra mật khẩu sớm thôi!😚", Toast.LENGTH_LONG).show();
            }
        });
    }

//    //ấn back 2 lần để thoát và đăng xuất
//    @Override
//    public void onBackPressed() {
//        if(backPressTime + 2000 > System.currentTimeMillis()){
//            super.onBackPressed();
//            return;
//        }else{
//            Toast.makeText(this, "Nhấn phím trở về ↩️ 1 lần nữa để thoát", Toast.LENGTH_SHORT).show();
//        }
//        backPressTime = System.currentTimeMillis();
//    }

    public void getView() {
        edtPhoneLogin = findViewById(R.id.edtPhoneLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);

        btnLogin = findViewById(R.id.btnLogin);

        tvRegisterLogin = findViewById(R.id.txtRegister);
        tvForgotPassword = findViewById(R.id.txtForgotPass);
    }
}