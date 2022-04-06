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

public class CarAdapter extends ArrayAdapter<Car> { //Bộ adapter để đẩy dữ liệu của các xe từ database vào từng item
    //khởi tạo
    public CarAdapter(Context context, ArrayList<Car> lstCar){
        super(context,0,lstCar);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Tạo view
        View currenView = convertView;
        if(currenView == null){
            currenView = LayoutInflater.from(getContext()).inflate(R.layout.item_car,parent,false); //ghép view hiện tại với layout item car để hiển thị từng xe
        }

        Car car = getItem(position); //khởi tạo đối tượng Car với vị trí của mảng (Array)

        //ánh xạ
        TextView tvName = currenView.findViewById(R.id.car_name);
        ImageView imgXe = currenView.findViewById(R.id.img_car);
        //thiết lập textview tên xe bằng phương thức get tên xe và ảnh xe bằng get mã ảnh 1 lên item car
        tvName.setText(car.getName());
        imgXe.setImageResource(car.getImg1());

        //trả về view hiện tại
        return currenView;
    }
}
