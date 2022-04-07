package com.vtlallklmc.autobook_btl.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vtlallklmc.autobook_btl.Car.CarDBHelper;

public class UserDatabaseData {
    CarDBHelper carDBHelper;
    Context context;

    //khoi tao
    public UserDatabaseData(Context context){
        this.context=context;
        this.carDBHelper = new CarDBHelper(context);
    }
    //thêm user - dang ky
    public void addUser(User user){
        ContentValues contentValues = new ContentValues();

        contentValues.put(CarDBHelper.PHONE,user.getPhone());
        contentValues.put(CarDBHelper.FULLNAME,user.getFullname());
        contentValues.put(CarDBHelper.PASSWORD,user.getPassword());
        contentValues.put(CarDBHelper.CARNAME,user.getCarname());
        contentValues.put(CarDBHelper.BOOKINGDATE,user.getBookingDate());

        SQLiteDatabase db = carDBHelper.getWritableDatabase();
        db.insert(CarDBHelper.USER_TB_NAME,null,contentValues);
        db.close();
    }
    //tìm user - đăng nhập
    public User findUserLogin(String query){
        SQLiteDatabase db = carDBHelper.getReadableDatabase();
        Cursor cursor = db.query(CarDBHelper.USER_TB_NAME,new String[]{CarDBHelper.PHONE,CarDBHelper.FULLNAME,
                CarDBHelper.PASSWORD,CarDBHelper.CARNAME,CarDBHelper.BOOKINGDATE},CarDBHelper.PHONE+"=?",new String[]{String.valueOf(query)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new User(
                cursor.getString(1),
                cursor.getString(0),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
    }
}
