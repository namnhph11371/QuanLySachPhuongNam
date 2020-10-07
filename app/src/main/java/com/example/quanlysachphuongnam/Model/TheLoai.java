package com.example.quanlysachphuongnam.Model;

public class TheLoai {
    private String MaSach ;
    private  String TenSach;
    private  String TheLoai;
    private  String TacGia;
    private  String NhaXuatBan;

    public TheLoai() {
    }

    public TheLoai(String maSach, String tenSach, String theLoai, String tacGia, String nhaXuatBan) {
        MaSach = maSach;
        TenSach = tenSach;
        TheLoai = theLoai;
        TacGia = tacGia;
        NhaXuatBan = nhaXuatBan;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String maSach) {
        MaSach = maSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        NhaXuatBan = nhaXuatBan;
    }
}
