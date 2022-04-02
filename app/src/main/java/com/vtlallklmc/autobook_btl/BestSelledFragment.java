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

public class BestSelledFragment extends Fragment {
    ListView lvBestSelledCar;
    ArrayList<Car> lstBestSelledCar = new ArrayList<>();
    CarAdapter carAdapter;
    Context context;

    DatabaseData databaseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.best_selled_fragment,container,false);

        lvBestSelledCar = view.findViewById(R.id.lvBestSelled);

        databaseData = new DatabaseData(inflater.getContext());
        lstBestSelledCar = databaseData.getBestSelledCar(); // lấy toàn bộ ArrayList Car
        carAdapter = new CarAdapter(inflater.getContext(),lstBestSelledCar); //lắp ArrayList vào Adapter
        lvBestSelledCar.setAdapter(carAdapter); // truyền Adapter vào listview để hiển thị lên
        return view;
    }
}
