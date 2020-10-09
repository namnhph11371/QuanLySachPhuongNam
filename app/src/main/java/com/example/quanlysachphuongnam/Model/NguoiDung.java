package com.example.quanlysachphuongnam.Model;

import android.graphics.Bitmap;

public class NguoiDung {
    private String UserName,PassWord,HoTen;
    private  String SoDienThoai;

    public NguoiDung() {
    }

    public NguoiDung(String userName, String passWord, String hoTen, String soDienThoai) {
        UserName = userName;
        PassWord = passWord;
        HoTen = hoTen;
        SoDienThoai = soDienThoai;
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
}
