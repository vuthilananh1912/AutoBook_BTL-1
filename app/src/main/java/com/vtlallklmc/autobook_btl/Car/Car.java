package com.vtlallklmc.autobook_btl.Car;

import android.net.Uri;

public class Car {  //Object Car để chứa các thuộc tính
    private int product_code; //mã xe
    private String name, brand, color; //tên, hãng, màu
    private int namsx, sl, img1, img2, img3, dungtich; //năm sx, số lượng, id ảnh 1, 2, 3
    private String hopso, muctieuthu; //hộp số, mức tiêu thu
    private int vmax; // vận tốc tối đa
    private double gia;

    //hàm khởi tạo có tham số
    public Car(int product_code, String name, String brand, String color, int namsx, int sl, int img1, int img2, int img3, int dungtich, String hopso, String muctieuthu, int vmax, double gia) {
        this.product_code = product_code;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.namsx = namsx;
        this.sl = sl;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.dungtich = dungtich;
        this.hopso = hopso;
        this.muctieuthu = muctieuthu;
        this.vmax = vmax;
        this.gia = gia;
    }


    //getter and setter
    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNamsx() {
        return namsx;
    }

    public void setNamsx(int namsx) {
        this.namsx = namsx;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public int getImg3() {
        return img3;
    }

    public void setImg3(int img3) {
        this.img3 = img3;
    }

    public int getDungtich() {
        return dungtich;
    }

    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }

    public String getHopso() {
        return hopso;
    }

    public void setHopso(String hopso) {
        this.hopso = hopso;
    }

    public String getMuctieuthu() {
        return muctieuthu;
    }

    public void setMuctieuthu(String muctieuthu) {
        this.muctieuthu = muctieuthu;
    }

    public int getVmax() {
        return vmax;
    }

    public void setVmax(int vmax) {
        this.vmax = vmax;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
