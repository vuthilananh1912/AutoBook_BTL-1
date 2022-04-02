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

        lvNewCar = view.findViewById(R.id.lvNewCar);

        databaseData = new DatabaseData(inflater.getContext());
        //chèn dữ liệu
        databaseData.insertCar(new Car(1,"BMW 320i GT 2016","BMW","Trắng",2016,4,R.drawable.bmw_1,+R.drawable.bmw_2,+R.drawable.bmw_3,3359,"Tự động","7.2l xăng/100km",280,1350000000));
        databaseData.insertCar(new Car(2,"BMW X5 2022","BMW","Trắng",2022,2,R.drawable.x5_1,+R.drawable.x5_2,+R.drawable.x5_3,3359,"Tự động","8.1l xăng/100km",320,4479000000.0));
        databaseData.insertCar(new Car(3,"Honda Civic 1.8 2022","Honda","Trắng",2022,6,R.drawable.civic_1,+R.drawable.civic_2,+R.drawable.cvic_3,1800,"Tự động","7.0l dầu/100km",260,738000000.0));
        databaseData.insertCar(new Car(4,"Honda CR-V 2.4AT 2022","Honda","Trắng",2022,2,R.drawable.crv_1,+R.drawable.crv_2,+R.drawable.crv_3,2000,"Sàn","6.4l dầu/100km",230,998000000.0));
        databaseData.insertCar(new Car(5,"Hyundai Elantra 2.0 2018","Hyundai","Đen",2018,10,R.drawable.elatran_1,+R.drawable.elatran_2,+R.drawable.elatran_3,2300,"Tự động","7l xăng/100km",240,575000000.0));
        databaseData.insertCar(new Car(6,"SANTAFE PREMIUM 2020","Hyundai","Trắng",2020,8,R.drawable.satafe_3,+R.drawable.satafe_2,+R.drawable.satafe_1,2359,"Tự động","7.2l xăng/100km",200,1100000000.0));
        databaseData.insertCar(new Car(7,"Kia K3 2022","Kia","Xám",2022,18,R.drawable.kia_k3_1,+R.drawable.kia_k3_2,+R.drawable.kia_k3_3,1600,"Sàn","6.7l xăng/100km",260,559000000.0));
        databaseData.insertCar(new Car(8,"Kia Seltos 1.4 Deluxe 2022","Kia","Trắng",2022,2,R.drawable.seltos_1,+R.drawable.seltos_2,+R.drawable.seltos_3,1450,"Tự động","6.9l xăng/100km",250,639000000.0));
        databaseData.insertCar(new Car(9,"Kia Sorento 2.2D Deluxe 2022","Kia","Trắng",2022,2,R.drawable.kia_1,+R.drawable.kia_2,+R.drawable.kia_3,1900,"Tự động","6.8l xăng/100km",240,999000000.0));
        databaseData.insertCar(new Car(10,"Mazda 3 1.5L Luxury 2022","Mazda","Đỏ",2022,3,R.drawable.mazda_1,+R.drawable.mazda_2,+R.drawable.mazda_3,1559,"Tự động","7.1l xăng/100km",250,686000000.0));
        databaseData.insertCar(new Car(11,"Mazda CX-5 2.0 Deluxe 2022","Mazda","Trắng",2022,2,R.drawable.cx5_1,+R.drawable.cx5_2,+R.drawable.cx5_3,1800,"Tự động","7.2l xăng/100km",260,818000000.0));
        databaseData.insertCar(new Car(12,"Mercedes-Benz C 200 Exclusive","Mercedes-Benz","Đỏ",2021,4,R.drawable.c200_1,+R.drawable.c200_2,+R.drawable.c200_3,1991,"Tự động","7.47l xăng/100km",239,1700000000.0));
        databaseData.insertCar(new Car(13,"Mercedes GLC 300 4MATIC 2021","Mercedes-Benz","Trắng",2021,1,R.drawable.glc_1,+R.drawable.glc_2,+R.drawable.glc_3,2010,"Tự động","7.8l xăng/100km",300,2530000000.0));
        databaseData.insertCar(new Car(14,"Mitsubishi Xpander 1.5MT 2020","Mitsubishi","Xám",2020,6,R.drawable.xpander_1,+R.drawable.xpander_2,+R.drawable.xpander_3,1959,"Sàn","6.1l xăng/100km",210,485000000.0));
        databaseData.insertCar(new Car(15,"VinFast Fadil 2021","VinFast","Đen",2021,1,R.drawable.fadil_1,+R.drawable.fadil_2,+R.drawable.fadil_3,1359,"Tự động","6.6l xăng/100km",230,368000000.0));
        databaseData.insertCar(new Car(16,"Vinfast Lux A2.0","VinFast","Đen",2020,2,R.drawable.vin_1,+R.drawable.vin_2,+R.drawable.vin_3,1559,"Tự động","7.1l xăng/100km",250,950000000.0));
        databaseData.insertCar(new Car(17,"VinFast LUX SA2.0","VinFast","Trắng",2021,3,R.drawable.sa_1,+R.drawable.sa_2,+R.drawable.sa_3,1659,"Tự động","7.1l xăng/100km",280,1170000000.0));

        lstNewCar = databaseData.getNewCar(); // lấy toàn bộ ArrayList Car
        carAdapter = new CarAdapter(inflater.getContext(),lstNewCar); //lắp ArrayList vào Adapter
        lvNewCar.setAdapter(carAdapter); // truyền Adapter vào listview để hiển thị lên

        return view;
    }

    private void getListCar(){


    }
}
