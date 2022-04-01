package com.vtlallklmc.autobook_btl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class carAdapter extends ArrayAdapter<car> {
    public carAdapter(Context context, ArrayList<car> lstCar){
        super(context,0,lstCar);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currenView = convertView;
        if(currenView == null){
            currenView = LayoutInflater.from(getContext()).inflate(R.layout.item_car,parent,false);
        }

        car car = getItem(position);

        TextView tvName = currenView.findViewById(R.id.car_name); //ánh xạ
        ImageView imgXe = currenView.findViewById(R.id.img_car);

        tvName.setText(car.getName());
        imgXe.setImageResource(car.getImg1());

        //chuyển dạng mảng byte thành image
//        Bitmap bitmap = BitmapFactory.decodeByteArray(car.getImg1(),0,car.getImg1().length);
//        imgXe.setImageBitmap(bitmap);
        //

        return currenView;
    }
}
