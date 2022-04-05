package com.vtlallklmc.autobook_btl.Car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vtlallklmc.autobook_btl.R;

import java.util.ArrayList;

public class CarAdapter extends ArrayAdapter<Car> {
    public CarAdapter(Context context, ArrayList<Car> lstCar){
        super(context,0,lstCar);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currenView = convertView;
        if(currenView == null){
            currenView = LayoutInflater.from(getContext()).inflate(R.layout.item_car,parent,false);
        }

        Car car = getItem(position);

        TextView tvName = currenView.findViewById(R.id.car_name); //ánh xạ
        ImageView imgXe = currenView.findViewById(R.id.img_car);

        tvName.setText(car.getName());
        imgXe.setImageResource(car.getImg1());

        return currenView;
    }
}
