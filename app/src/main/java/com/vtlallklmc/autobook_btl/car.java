package com.vtlallklmc.autobook_btl;

public class car {
    private byte[] img1, img2, img3;
    private int product_code, namSX, sl;
    private String name, brand, color;

    public car(byte[] img1, byte[] img2, byte[] img3, int product_code, int namSX, int sl, String name, String brand, String color) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.product_code = product_code;
        this.namSX = namSX;
        this.sl = sl;
        this.name = name;
        this.brand = brand;
        this.color = color;
    }

    public byte[] getImg1() {
        return img1;
    }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }

    public byte[] getImg3() {
        return img3;
    }

    public void setImg3(byte[] img3) {
        this.img3 = img3;
    }

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
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
}
