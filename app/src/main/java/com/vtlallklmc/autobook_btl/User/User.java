package com.vtlallklmc.autobook_btl.User;

import java.util.Calendar;

public class User {
    private String fullname, phone, password, carname, bookingDate;

    public User(String name, String phone, String password, String carname, String bookingDate) {
        this.fullname = name;
        this.phone = phone;
        this.password = password;
        this.carname = carname;
        this.bookingDate = bookingDate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String name) {
        this.fullname = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
