package com.example.quanlysachphuongnam.Model;

import java.util.Date;

public class HoaDon {
    private  String MaHoaDon;
    private String NgayMua;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String ngayMua) {
        MaHoaDon = maHoaDon;
        NgayMua = ngayMua;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String ngayMua) {
        NgayMua = ngayMua;
    }
}
