package com.vtlallklmc.autobook_btl.User;

import java.util.Calendar;

public class User {
    private String name, username, phone, password, carname, bookingDate;

    public User(String name, String username, String phone, String password, String carname, String bookingDate) {
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.carname = carname;
        this.bookingDate = bookingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
