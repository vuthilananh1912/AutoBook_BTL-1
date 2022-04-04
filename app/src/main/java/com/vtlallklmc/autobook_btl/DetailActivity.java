package com.vtlallklmc.autobook_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    DatabaseData databaseData;
    TextView tvName,tvGia,tvDatCoc,tvColor,tvDungTich,tvHopSo,tvMucTieuThu,tvVmax;
    ImageView img1, img2, img3;
    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent receivedIntent = getIntent();
        String mess = receivedIntent.getStringExtra("keyword");

        //ánh xạ
        tvName = findViewById(R.id.tvName);
        img1 = findViewById(R.id.img1);
        tvGia = findViewById(R.id.tvGia);
        tvDatCoc = findViewById(R.id.tvDatCoc);
        tvColor = findViewById(R.id.tvColor);
        tvDungTich = findViewById(R.id.tvDungTich);
        tvHopSo = findViewById(R.id.tvHopSo);
        tvMucTieuThu = findViewById(R.id.tvMucTieuThu);
        tvVmax = findViewById(R.id.tvVmax);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        btnBook = findViewById(R.id.btnBook);


        databaseData = new DatabaseData(this);
        Car car = databaseData.searchCar(mess);
        tvName.setText(car.getName());

        img1.setImageResource(car.getImg1());

        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        String gia = "Giá bán: "+format.format((long) car.getGia()).toString();
        tvGia.setText(gia);

        String datcoc = "Đặt cọc: "+format.format((long) (car.getGia()*0.01)).toString()+"     (1% Giá bán)";
        tvDatCoc.setText(datcoc);

        tvColor.setText("Màu sắc: "+car.getColor());
        tvDungTich.setText("Dung tích: "+car.getDungtich()+" cc");
        tvHopSo.setText("Hộp số: "+car.getHopso());
        tvMucTieuThu.setText("Mức tiêu thụ: "+car.getMuctieuthu());
        tvVmax.setText("Vận tốc tối đa: "+car.getVmax()+" km/h");

        img2.setImageResource(car.getImg2());
        img3.setImageResource(car.getImg3());

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookingIntent = new Intent(DetailActivity.this,BookingActivity.class);
                startActivity(bookingIntent);
            }
        });
    }
}