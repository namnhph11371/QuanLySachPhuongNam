package com.example.quanlysachphuongnam.Model;

import java.util.Date;

public class HoaDonChiTiet {
    private  String MaHoaDonChiTiet;
    private  String MaHoaDon;
    private String NgayMua;
    private  String TenNguoiMua;
    private  String TenNguoiBan;
    private  String TenSach;
    private  int SoLuongMua;
    private  String DiaChiNguoiMua;
    private  float TongTien;
    private  Double ThanhToan;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDonChiTiet, String maHoaDon, String ngayMua, String tenNguoiMua, String tenNguoiBan, String tenSach, int soLuongMua, String diaChiNguoiMua, float tongTien, Double thanhToan) {
        MaHoaDonChiTiet = maHoaDonChiTiet;
        MaHoaDon = maHoaDon;
        NgayMua = ngayMua;
        TenNguoiMua = tenNguoiMua;
        TenNguoiBan = tenNguoiBan;
        TenSach = tenSach;
        SoLuongMua = soLuongMua;
        DiaChiNguoiMua = diaChiNguoiMua;
        TongTien = tongTien;
        ThanhToan = thanhToan;
    }

    public String getMaHoaDonChiTiet() {
        return MaHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
        MaHoaDonChiTiet = maHoaDonChiTiet;
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

    public String getTenNguoiMua() {
        return TenNguoiMua;
    }

    public void setTenNguoiMua(String tenNguoiMua) {
        TenNguoiMua = tenNguoiMua;
    }

    public String getTenNguoiBan() {
        return TenNguoiBan;
    }

    public void setTenNguoiBan(String tenNguoiBan) {
        TenNguoiBan = tenNguoiBan;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        SoLuongMua = soLuongMua;
    }

    public String getDiaChiNguoiMua() {
        return DiaChiNguoiMua;
    }

    public void setDiaChiNguoiMua(String diaChiNguoiMua) {
        DiaChiNguoiMua = diaChiNguoiMua;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }

    public Double getThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(Double thanhToan) {
        ThanhToan = thanhToan;
    }
}
