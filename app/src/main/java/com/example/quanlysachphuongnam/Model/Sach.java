package com.example.quanlysachphuongnam.Model;

public class Sach {
    private  String MaSach;
    private  String MaTheLoai;
    private  String TenSach;
    private  String TacGia;
    private  String NhaXuatban;
    private  float GiaBan;
    private  float SoLuong;

    public Sach(String maSach, String maTheLoai, String tenSach, String tacGia, String nhaXuatban, float giaBan, float soLuong) {
        MaSach = maSach;
        MaTheLoai = maTheLoai;
        TenSach = tenSach;
        TacGia = tacGia;
        NhaXuatban = nhaXuatban;
        GiaBan = giaBan;
        SoLuong = soLuong;
    }

    public Sach() {

    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String maSach) {
        MaSach = maSach;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        MaTheLoai = maTheLoai;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getNhaXuatban() {
        return NhaXuatban;
    }

    public void setNhaXuatban(String nhaXuatban) {
        NhaXuatban = nhaXuatban;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float giaBan) {
        GiaBan = giaBan;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float soLuong) {
        SoLuong = soLuong;
    }
}
