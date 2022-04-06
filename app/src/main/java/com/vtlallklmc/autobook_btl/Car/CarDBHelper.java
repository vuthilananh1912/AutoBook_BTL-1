package com.vtlallklmc.autobook_btl.Car;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CarDBHelper extends SQLiteOpenHelper { //Lớp này để khởi tạo SQLite bao gồm tạo database và tạo bảng
    public static final String DB_NAME = "car.db"; //tên db
    public static final int DB_VER = 1;

    public static String TB_NAME = "tblCar"; //tên bảng Car

    //thuộc tính bảng Car
    public static String NAMSX = "nam_sx", SL = "soluong", DUNGTICH = "dung_tich", HOPSO = "hop_so", MUCTIEUTHU = "muc_tieu_thu", VMAX = "v_max", GIA = "gia";
    public static String NAME = "name", PRODUCT_CODE = "product_code", BRAND = "brand", COLOR = "color", IMG_CODE1 = "image_code1", IMG_CODE2 = "image_code2", IMG_CODE3 = "image_code3";

    public Context context; //khởi tạo 1 đối tượng context

    //tạo bảng
    String sql = "CREATE TABLE "+TB_NAME+" ("
            + PRODUCT_CODE + " INTEGER PRIMARY KEY, "
            + NAME + " TEXT, "
            + BRAND + " TEXT, "
            + COLOR + " TEXT, "
            + NAMSX + " INTEGER, "
            + SL + " INTEGER, "
            + IMG_CODE1 + " INTEGER, "
            + IMG_CODE2 + " INTEGER, "
            + IMG_CODE3 + " INTEGER, "
            + DUNGTICH + " INTEGER, "
            + HOPSO + " TEXT, "
            + MUCTIEUTHU + " TEXT, "
            + VMAX + " INTEGER, "
            + GIA + " REAL); ";

    //khởi tạo
    public CarDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context = context;
    }

    //phương thức này chạy ngay khi mở app
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
    }

    //phương thức update bảng
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TB_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
