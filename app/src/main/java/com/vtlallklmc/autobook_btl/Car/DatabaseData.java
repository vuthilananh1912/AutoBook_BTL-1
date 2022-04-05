package com.vtlallklmc.autobook_btl.Car;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatabaseData {
    CarDBHelper carDBHelper;
    Context context;

    public DatabaseData(Context context) {

        this.context = context;
        this.carDBHelper = new CarDBHelper(context);
    }
    public void insertCar(Car car){
        ContentValues contentValues = new ContentValues();

        contentValues.put(CarDBHelper.PRODUCT_CODE, car.getProduct_code());
        contentValues.put(CarDBHelper.NAME, car.getName());
        contentValues.put(CarDBHelper.BRAND, car.getBrand());
        contentValues.put(CarDBHelper.COLOR, car.getColor());
        contentValues.put(CarDBHelper.NAMSX, car.getNamsx());
        contentValues.put(CarDBHelper.SL, car.getSl());
        contentValues.put(CarDBHelper.IMG_CODE1, car.getImg1());
        contentValues.put(CarDBHelper.IMG_CODE2,car.getImg2());
        contentValues.put(CarDBHelper.IMG_CODE3, car.getImg3());
        contentValues.put(CarDBHelper.DUNGTICH, car.getDungtich());
        contentValues.put(CarDBHelper.HOPSO, car.getHopso());
        contentValues.put(CarDBHelper.MUCTIEUTHU, car.getMuctieuthu());
        contentValues.put(CarDBHelper.VMAX, car.getVmax());
        contentValues.put(CarDBHelper.GIA, car.getGia());

        SQLiteDatabase db = carDBHelper.getWritableDatabase();
        long result = db.insert(CarDBHelper.TB_NAME,null,contentValues);
        db.close();
//        if(result!=-1)
//            Toast.makeText(context, "Thêm thành công!", Toast.LENGTH_SHORT).show();
//        else Toast.makeText(context, "Thêm thất bại!", Toast.LENGTH_SHORT).show();
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
    public ArrayList<Car> getNewCar(){
        ArrayList<Car> lstCar = new ArrayList<>();

        SQLiteDatabase db = carDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+CarDBHelper.TB_NAME+" ORDER BY nam_sx DESC LIMIT 10",null);
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
    public ArrayList<Car> getBestSelledCar(){
        ArrayList<Car> lstCar = new ArrayList<>();

        SQLiteDatabase db = carDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+CarDBHelper.TB_NAME+" ORDER BY soluong ASC LIMIT 10",null);
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
    public ArrayList<Car> getCarbyBrand(){
        ArrayList<Car> lstCar = new ArrayList<>();

        SQLiteDatabase db = carDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+CarDBHelper.TB_NAME+" ORDER BY brand ASC",null);
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
    public Car searchCar(String query){

        SQLiteDatabase db = carDBHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * from "+CarDBHelper.TB_NAME+" WHERE name like '%"+query+"%'",null);
//        while (cursor.moveToNext()){
//            Car c = new Car(
//                    cursor.getInt(0),
//                    cursor.getString(1),
//                    cursor.getString(2),
//                    cursor.getString(3),
//                    cursor.getInt(4),
//                    cursor.getInt(5),
//                    cursor.getInt(6),
//                    cursor.getInt(7),
//                    cursor.getInt(8),
//                    cursor.getInt(9),
//                    cursor.getString(10),
//                    cursor.getString(11),
//                    cursor.getInt(12),
//                    cursor.getDouble(13)
//            );
//        }
        Cursor cursor = db.query(CarDBHelper.TB_NAME,new String[]{CarDBHelper.PRODUCT_CODE,CarDBHelper.NAME,CarDBHelper.BRAND,CarDBHelper.COLOR,CarDBHelper.NAMSX,CarDBHelper.SL,
                CarDBHelper.IMG_CODE1,CarDBHelper.IMG_CODE2,CarDBHelper.IMG_CODE3,CarDBHelper.DUNGTICH,CarDBHelper.HOPSO,CarDBHelper.MUCTIEUTHU,CarDBHelper.VMAX,CarDBHelper.GIA},CarDBHelper.NAME+"=?",new String[]{String.valueOf(query)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new Car(
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
                    cursor.getDouble(13));
    }
    public ArrayList<String> getAllCarName(){
        ArrayList<String> lstCar = new ArrayList<>();

        SQLiteDatabase db = carDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+CarDBHelper.NAME+" FROM "+CarDBHelper.TB_NAME,null);
        while (cursor.moveToNext()){
            lstCar.add(cursor.getString(0));
        }
        return lstCar;
    }
}
