package com.vtlallklmc.autobook_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vtlallklmc.autobook_btl.Main_Fragments.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {
    Button btnDate, btnSave, btnCancel;
    String getDate, getTime, message;
    TextView tvDate, tvTime;
    long rawDate;
    Calendar datetime;
    Calendar currentDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //ánh xạ
        btnDate = findViewById(R.id.btnDate);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);

        //nhận name của intent Detail Activity
        Intent receiveIntent = getIntent();
        String nameCar = receiveIntent.getStringExtra("name");
        //

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateTimePicker();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getDate==null || getTime==null){
                    AlertDialog.Builder require = new AlertDialog.Builder(BookingActivity.this);
                    require.setMessage("Vui lòng chọn lại ngày giờ đặt mua!");
                    require.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //nothing
                        }
                    });
                    require.show();
                }else{
                    AlertDialog.Builder confirm = new AlertDialog.Builder(BookingActivity.this);
                    confirm.setTitle("Xác nhận đặt lịch");
                    confirm.setIcon(R.drawable.round_loyalty_24);
                    message = "Xe ô tô "+nameCar+"\nNgày: "+getDate+"\nThời gian: "+getTime+"\nĐịa điểm: Showroom FITHOU - 96 Định Công, Thanh Xuân, Hà Nội.";
                    confirm.setMessage("Xác nhận đặt lịch mua xe:\n"+message);
                    confirm.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent pushIntent = new Intent(Intent.ACTION_INSERT);

                            pushIntent.setData(CalendarContract.Events.CONTENT_URI);

                            pushIntent.putExtra(CalendarContract.Events.TITLE, "Sự kiện mua xe "+nameCar+" ("+getDate+" - "+getTime+")");
                            pushIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "96 Định Công, Thanh Xuân, Hà Nội");
                            pushIntent.putExtra(CalendarContract.Events.DESCRIPTION, message);
//                            pushIntent.putExtra(CalendarContract.Events.ALL_DAY, true);
                            pushIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,rawDate);
                            pushIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,rawDate+120*60*1000);
//                            pushIntent.putExtra(Intent.EXTRA_EMAIL, "20a10010156@students.hou.edu.vn");
                            pushIntent.putExtra(CalendarContract.Events.CALENDAR_ID, 1);
                            pushIntent.putExtra(CalendarContract.Events.EVENT_TIMEZONE, Calendar.getInstance().getTimeZone().getID());

                            startActivity(pushIntent);
                            Toast.makeText(BookingActivity.this, "Ấn nút 'Lưu' ở góc trên bên phải để lưu sự kiện trọng đại này nhé!", Toast.LENGTH_LONG).show();
                        }
                    });
                    confirm.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent goHomeIntent = new Intent(BookingActivity.this, MainActivity.class);
                            startActivity(goHomeIntent);
                        }
                    });
                    confirm.show();
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHomeIntent = new Intent(BookingActivity.this, MainActivity.class);
                startActivity(goHomeIntent);
            }
        });
    }
    public void datePicker(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int nam, int thang, int ngay) {
                calendar.set(nam,thang,ngay);
                rawDate = calendar.getTimeInMillis();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                getDate = simpleDateFormat.format(calendar.getTime());
                tvDate.setText("Ngày mua: "+simpleDateFormat.format(calendar.getTime()));
            }
        },year,month,day);
        datePickerDialog.show();
    }
    public void timePicker(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int gio, int phut) {
                calendar.set(0,0,0,gio,phut);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                getTime = simpleDateFormat.format(calendar.getTime());
                tvTime.setText("Giờ mua: "+simpleDateFormat.format(calendar.getTime()));
            }
        },hour,minute,true);
        timePickerDialog.show();
    }
    public void dateTimePicker(){
        currentDateTime = Calendar.getInstance();
        datetime = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(BookingActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                datetime.set(year,monthOfYear,dayOfMonth);
                TimePickerDialog timePickerDialog = new TimePickerDialog(BookingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        datetime.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        datetime.set(Calendar.MINUTE,minute);
                        rawDate = datetime.getTimeInMillis();

                        getDate = new SimpleDateFormat("dd/MM/yyyy").format(datetime.getTime());
                        tvDate.setText("Ngày mua: "+getDate);
                        getTime = new SimpleDateFormat("HH:mm").format(datetime.getTime());
                        tvTime.setText("Giờ mua: "+getTime);
                    }
                },currentDateTime.get(Calendar.HOUR_OF_DAY),currentDateTime.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        },currentDateTime.get(Calendar.YEAR),currentDateTime.get(Calendar.MONTH),currentDateTime.get(Calendar.DATE));
        datePickerDialog.show();
    }
}