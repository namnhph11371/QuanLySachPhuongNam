package com.example.quanlysachphuongnam.Model;

import android.graphics.Bitmap;

public class NguoiDung {
    private String UserName,PassWord,HoTen;
    private  String SoDienThoai;
    private  Bitmap images;

    public NguoiDung(String userName, String passWord, String hoTen, String soDienThoai, Bitmap images) {
        UserName = userName;
        PassWord = passWord;
        HoTen = hoTen;
        SoDienThoai = soDienThoai;
        this.images = images;
    }

    public NguoiDung() {
        
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public Bitmap getImages() {
        return images;
    }

    public void setImages(Bitmap images) {
        this.images = images;
    }
}
