package com.vtlallklmc.autobook_btl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class BrandFragment extends Fragment {
    ListView lvBrandCar;
    ArrayList<Car> lstBrandCar = new ArrayList<>();
    CarAdapter carAdapter;
    Context context;

    DatabaseData databaseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.brand_fragment,container,false);

        lvBrandCar = view.findViewById(R.id.lvBrand);

        databaseData = new DatabaseData(inflater.getContext());
        lstBrandCar = databaseData.getCarbyBrand(); // lấy toàn bộ ArrayList Car
        carAdapter = new CarAdapter(inflater.getContext(),lstBrandCar); //lắp ArrayList vào Adapter
        lvBrandCar.setAdapter(carAdapter); // truyền Adapter vào listview để hiển thị lên

        return view;
    }
}
