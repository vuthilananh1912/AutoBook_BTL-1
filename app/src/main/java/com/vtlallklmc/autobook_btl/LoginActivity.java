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

public class LoginActivity extends AppCompatActivity {

    EditText edtsdt, edtPass;
    CheckBox cBLuuMK;
    Button btnDN;
    TextView txtViewDK, txtViewQuenMK;

    private String phoneUser = "";

    private long backPressTime;

    UserDatabaseData userDatabaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtsdt = (EditText) findViewById(R.id.edtsdt);
        edtPass = (EditText) findViewById(R.id.edtPass);
//        cBLuuMK = (CheckBox) findViewById(R.id.cBLuuMK);
        btnDN = (Button) findViewById(R.id.btnDN);
        txtViewDK = (TextView) findViewById(R.id.txtViewDK);
        txtViewQuenMK = (TextView) findViewById(R.id.txtViewQuenMK);

        //khởi tạo class database để chuẩn bị chèn user
        userDatabaseData = new UserDatabaseData(LoginActivity.this);

        //chèn user mẫu :v
        //userDatabaseData.addUser(new User("Lê Mạnh Cường","0372843798","cuong1806","GLC 300","18/06/2022"));

//        User userInfo = userDatabaseData.findUserLogin("0372843798");
//        phoneUser = userInfo.getPhone();
    }

    //ấn back 2 lần để thoát và đăng xuất
    @Override
    public void onBackPressed() {
        if(backPressTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            Toast.makeText(this, "Nhấn phím trở về ↩️ 1 lần nữa để thoát", Toast.LENGTH_SHORT).show();
        }
        backPressTime = System.currentTimeMillis();
    }

//    public void rememberPass(String userName, String Pass, boolean status)
//    {
//        SharedPreferences sPref = getSharedPreferences( "User", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sPref.edit();
//        if(status == false)
//        {
//            editor.clear();
//        }
//        else {
//            editor.putString("USERNAME", userName);
//            editor.putString("PASSWORD", Pass);
//            editor.putBoolean("REMEMBER", status);
//        }
//        editor.commit();
//    }
    public int checkLogin(String u, String p)
    {
        if (u.equals("admin") && p.equals("admin"))
        {
            return 1;
        }else
        {
            return 0;
        }
    }

    String strU, strP;
    public void checkLogin( View view){
        strU = edtsdt.getText().toString();
        strP = edtPass.getText().toString();
        if (strU.isEmpty() || strP.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Số điện thoại và Mật khẩu không được để trống",
                    Toast.LENGTH_LONG).show();
        }else {
            if (checkLogin(strU, strP)>0)
            {
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công",
                        Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent loginToMainIntent = new Intent( getApplicationContext(), MainActivity.class);
                        loginToMainIntent.putExtra("phoneUser",phoneUser);
                        startActivity(loginToMainIntent);
                    }
                }, 2000);
            }
        }
    }

//    public void savePass(View view){
//        String userName = edtsdt.getText().toString();
//        String Pass = edtPass.getText().toString();
//        boolean status = cBLuuMK.isChecked();
//        rememberPass(userName, Pass, status);
//    }
    public void register(View view){
        Intent intent = new Intent( this, Register.class);
        startActivity(intent);
        finish();
    }
    public void quenMK(View view){
        Toast.makeText(this, "Hãy giải lao đi, khi khác quay lại bạn sẽ nhớ lại mật khẩu thôi", Toast.LENGTH_LONG).show();
    }
}