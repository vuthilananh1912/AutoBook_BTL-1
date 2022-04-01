package com.vtlallklmc.autobook_btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseData {
    CarDBHelper carDBHelper;
    Context context;

    public DatabaseData(Context context) {
        this.carDBHelper = new CarDBHelper(context);
    }
    public void insertCar(Car car){
        ContentValues contentValues = new ContentValues();

        contentValues.put("product_code", car.getProduct_code());
        contentValues.put("name", car.getName());
        contentValues.put("brand", car.getBrand());
        contentValues.put("color", car.getColor());
        contentValues.put("namSX", car.getNamsx());
        contentValues.put("sl", car.getSl());
        contentValues.put("img1", car.getImg1());
        contentValues.put("img2",car.getImg2());
        contentValues.put("img3", car.getImg3());
        contentValues.put("dungtich", car.getDungtich());
        contentValues.put("hopso", car.getHopso());
        contentValues.put("muctieuthu", car.getMuctieuthu());
        contentValues.put("vmax", car.getVmax());
        contentValues.put("gia", car.getGia());

        SQLiteDatabase db = carDBHelper.getWritableDatabase();
        long result = db.insert(CarDBHelper.TB_NAME,null,contentValues);
        //db.close();
        if(result!=-1)
            Toast.makeText(context, "Thêm thành công!", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Thêm thất bại!", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Car> getAllCar(){
        ArrayList<Car> lstCar = new ArrayList<>();

        SQLiteDatabase db = carDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+CarDBHelper.TB_NAME,null);
        while (cursor.moveToNext()){
            Car c = new Car(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getInt(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getInt(12),
                    cursor.getDouble(13)
            );
            lstCar.add(c);
        }
        return lstCar;
    }
}
