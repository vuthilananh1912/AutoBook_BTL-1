package com.vtlallklmc.autobook_btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class carDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "car.db";
    public static final int DB_VER = 1;
    public static String TB_NAME = "tblCar";
    public static String NAMSX = "nam_sx", SL = "soluong", DUNGTICH = "dung_tich", HOPSO = "hop_so", MUCTIEUTHU = "muc_tieu_thu", VMAX = "v_max", GIA = "gia";
    public static String NAME = "name", PRODUCT_CODE = "product_code", BRAND = "brand", COLOR = "color", IMG_CODE1 = "image_code1", IMG_CODE2 = "image_code2", IMG_CODE3 = "image_code3";
    public Context context;

    private String SQLQuery = "INSERT INTO tblCar VALUES " +
            "(null,'BMW 320i GT 2016','BMW','Trắng','2016','4',";

    public carDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+TB_NAME+" ("
                + PRODUCT_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT, "
                + BRAND + " TEXT, "
                + COLOR + " TEXT, "
                + NAMSX + " INTEGER, "
                + SL + " INTEGER, "
                + IMG_CODE1 + " BLOB, "
                + IMG_CODE2 + " BLOB, "
                + IMG_CODE3 + " BLOB, "
                + DUNGTICH + " REAL, "
                + HOPSO + " TEXT, "
                + MUCTIEUTHU + " REAL, "
                + VMAX + " REAL, "
                + GIA + " REAL); ";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TB_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public void insertCar(car car){
        ContentValues contentValues = new ContentValues();
        contentValues.put("product_code", PRODUCT_CODE);
        contentValues.put("name", NAME);
        contentValues.put("brand", BRAND);
        contentValues.put("color", COLOR);
        contentValues.put("namSX", NAMSX);
        contentValues.put("sl", SL);
        contentValues.put("img1", IMG_CODE1);
        contentValues.put("img2",IMG_CODE2);
        contentValues.put("img3", IMG_CODE3);

        SQLiteDatabase db = getWritableDatabase();
        long result =db.insert(TB_NAME,null,contentValues);
        if(result!=-1)
            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
    }
//    public void updateCar(com.vtlallklmc.autobook_btl.car car, int product_code){
//        ContentValues cvUpdate = new ContentValues();
//        cvUpdate.put("product_code", PRODUCT_CODE);
//        cvUpdate.put("name", NAME);
//        cvUpdate.put("brand", BRAND);
//        cvUpdate.put("color", COLOR);
//        cvUpdate.put("namSX", NAMSX);
//        cvUpdate.put("sl", SL);
//        cvUpdate.put("img1", IMG_CODE1);
//        cvUpdate.put("img2",IMG_CODE2);
//        cvUpdate.put("img3", IMG_CODE3);
//
//        SQLiteDatabase db = getWritableDatabase();
//        int result = db.update(TB_NAME,cvUpdate,PRODUCT_CODE + " = ?", new String[] {product_code});
//        if (result>0)
//            Toast.makeText(context, "Update Successfully!", Toast.LENGTH_SHORT).show();
//        else Toast.makeText(context, "Update Failed!", Toast.LENGTH_SHORT).show();
//    }



//chuyển ảnh thành 1 mảng byte
    public byte[] imgToByteArray(ImageView imgView){
        BitmapDrawable img = (BitmapDrawable) imgView.getDrawable(); //khởi tạo, truyền ImageView
        Bitmap bmp = img.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream(); //khởi tạo luồng xuất mảng byte
        bmp.compress(Bitmap.CompressFormat.JPEG,100,stream); // nén ảnh định dạng JPEG chất lượng 100 với luồng xuất trên
        byte[] byteArray = stream.toByteArray(); //khai báo mảng byte, gán dữ liệu từ luồng xuất ra mảng byte;
        return byteArray;
    }
}
