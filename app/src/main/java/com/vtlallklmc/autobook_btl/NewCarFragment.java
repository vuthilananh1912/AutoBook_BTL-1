package com.vtlallklmc.autobook_btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class NewCarFragment extends Fragment {
    ListView lvNewCar;
    ArrayList<Car> lstNewCar = new ArrayList<>();
    CarAdapter carAdapter;
    Context context;

    DatabaseData databaseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_car_fragment,container,false);

        databaseData = new DatabaseData(inflater.getContext());

        lvNewCar = view.findViewById(R.id.lvNewCar);
//        databaseData.insertCar(new Car(1,"BMW 320i GT 2016","BMW","Trắng",2016,4,R.drawable.bmw_1,+R.drawable.bmw_2,+R.drawable.bmw_3,3359,"Tự dộng","7.2l xăng/100km",280,1350000000));
//        databaseData.insertCar(new Car(2,"BMW X5 2022","BMW","Trắng",2022,2,R.drawable.x5_1,+R.drawable.x5_2,+R.drawable.x5_3,3359,"Tự dộng","8.1l xăng/100km",320,4479000000.0));
        //db.insert(CarDBHelper.TB_NAME,null,)
        //lstNewCar.add(new Car(1,"BMW 320i GT 2016","BMW","Trắng",2016,4,R.drawable.bmw_1,+R.drawable.bmw_2,+R.drawable.bmw_3,3359,"Tự dộng","7.2l xăng/100km",280,1350000000));
        lstNewCar = databaseData.getAllCar();
//        Toast.makeText(inflater.getContext(), lstNewCar.size(), Toast.LENGTH_SHORT).show();
        carAdapter = new CarAdapter(inflater.getContext(),lstNewCar);
        lvNewCar.setAdapter(carAdapter);

        return view;
    }

    private void getListCar(){


    }
}
