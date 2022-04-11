package com.vtlallklmc.autobook_btl.Main_Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vtlallklmc.autobook_btl.Car.Car;
import com.vtlallklmc.autobook_btl.Car.CarAdapter;
import com.vtlallklmc.autobook_btl.Car.DatabaseData;
import com.vtlallklmc.autobook_btl.DetailActivity;
import com.vtlallklmc.autobook_btl.R;

import java.util.ArrayList;

public class BestSelledFragment extends Fragment {
    ListView lvBestSelledCar;
    ArrayList<Car> lstBestSelledCar = new ArrayList<>();
    CarAdapter carAdapter;
    Context context;

    private MainActivity parentActivity;
    DatabaseData databaseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.best_selled_fragment,container,false);
        parentActivity = (MainActivity) getActivity();

        lvBestSelledCar = view.findViewById(R.id.lvBestSelled);

        databaseData = new DatabaseData(inflater.getContext());
        lstBestSelledCar = databaseData.getBestSelledCar(); // lấy toàn bộ ArrayList Car
        carAdapter = new CarAdapter(inflater.getContext(),lstBestSelledCar); //lắp ArrayList vào Adapter
        lvBestSelledCar.setAdapter(carAdapter); // truyền Adapter vào listview để hiển thị lên

        lvBestSelledCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentSend = new Intent(inflater.getContext(), DetailActivity.class);
                intentSend.putExtra("keyword",lstBestSelledCar.get(i).getName());
                startActivity(intentSend);
            }
        });
        return view;
    }
}
