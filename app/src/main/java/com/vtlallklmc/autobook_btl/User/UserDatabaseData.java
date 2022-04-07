package com.vtlallklmc.autobook_btl.User;

import android.content.Context;

import com.vtlallklmc.autobook_btl.Car.CarDBHelper;

public class UserDatabaseData {
    CarDBHelper carDBHelper;
    Context context;

    //khoi tao
    public UserDatabaseData(Context context){
        this.context=context;
        this.carDBHelper = new CarDBHelper(context);
    }
}
