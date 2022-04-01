package com.vtlallklmc.autobook_btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CarDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "car.db";
    public static final int DB_VER = 1;

    public static String TB_NAME = "tblCar";

    public static String NAMSX = "nam_sx", SL = "soluong", DUNGTICH = "dung_tich", HOPSO = "hop_so", MUCTIEUTHU = "muc_tieu_thu", VMAX = "v_max", GIA = "gia";
    public static String NAME = "name", PRODUCT_CODE = "product_code", BRAND = "brand", COLOR = "color", IMG_CODE1 = "image_code1", IMG_CODE2 = "image_code2", IMG_CODE3 = "image_code3";

    public Context context;

    String SQLQuery = "INSERT INTO "+TB_NAME+" VALUES(1,'BMW 320i GT 2016','BMW','Trắng',2016,4,"+R.drawable.bmw_1+","+R.drawable.bmw_2+","+R.drawable.bmw_3+",3359,'Tự dộng','7.2l xăng/100km',280,1350000000)";
    String SQLQuery1 = "INSERT INTO "+TB_NAME+" VALUES(1,'BMW X5 2022','BMW','Trắng',2022,2,"+R.drawable.x5_1+","+R.drawable.x5_2+","+R.drawable.x5_3+",3359,'Tự dộng','8.1l xăng/100km',320,4479000000)";

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

    public CarDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(SQLQuery);
        sqLiteDatabase.execSQL(SQLQuery1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TB_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
//    public void insertCar(Car car){
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put("product_code", car.getProduct_code());
//        contentValues.put("name", car.getName());
//        contentValues.put("brand", car.getBrand());
//        contentValues.put("color", car.getColor());
//        contentValues.put("namSX", car.getNamsx());
//        contentValues.put("sl", car.getSl());
//        contentValues.put("img1", car.getImg1());
//        contentValues.put("img2",car.getImg2());
//        contentValues.put("img3", car.getImg3());
//        contentValues.put("dungtich", car.getDungtich());
//        contentValues.put("hopso", car.getHopso());
//        contentValues.put("muctieuthu", car.getMuctieuthu());
//        contentValues.put("vmax", car.getVmax());
//        contentValues.put("gia", car.getGia());
//
//        SQLiteDatabase db = getWritableDatabase();
//        long result = db.insert(TB_NAME,null,contentValues);
//        if(result!=-1)
//            Toast.makeText(context, "Thêm thành công!", Toast.LENGTH_SHORT).show();
//        else Toast.makeText(context, "Thêm thất bại!", Toast.LENGTH_SHORT).show();
//    }

//    public ArrayList<Car> getAllCar(){
//        ArrayList<Car> lstCar = new ArrayList<>();
//
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM "+TB_NAME,null);
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
//            lstCar.add(c);
//        }
//        return lstCar;
//    }

////chuyển ảnh thành 1 mảng byte
//    public byte[] imgToByteArray(ImageView imgView){
//        BitmapDrawable img = (BitmapDrawable) imgView.getDrawable(); //khởi tạo, truyền ImageView
//        Bitmap bmp = img.getBitmap();
//
//        ByteArrayOutputStream stream = new ByteArrayOutputStream(); //khởi tạo luồng xuất mảng byte
//        bmp.compress(Bitmap.CompressFormat.JPEG,100,stream); // nén ảnh định dạng JPEG chất lượng 100 với luồng xuất trên
//        byte[] byteArray = stream.toByteArray(); //khai báo mảng byte, gán dữ liệu từ luồng xuất ra mảng byte;
//        return byteArray;
//    }
}
