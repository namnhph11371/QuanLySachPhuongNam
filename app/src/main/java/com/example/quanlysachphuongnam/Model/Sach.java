package com.example.quanlysachphuongnam.Model;

public class Sach {
    private  String MaSach;
    private  String MaTheLoai;
    private  String TenSach;
    private  float GiaNhap;
    private  String TieuDe;
    private  String TacGia;
    private  String NhaXuatban;
    private  float GiaBan;
    private  int SoLuong;

    public Sach(String maSach, String maTheLoai, String tenSach, float giaNhap, String tieuDe, String tacGia, String nhaXuatban, float giaBan, int soLuong) {
        MaSach = maSach;
        MaTheLoai = maTheLoai;
        TenSach = tenSach;
        GiaNhap = giaNhap;
        TieuDe = tieuDe;
        TacGia = tacGia;
        NhaXuatban = nhaXuatban;
        GiaBan = giaBan;
        SoLuong = soLuong;
    }

    public Sach(String masach, String tensach, String giaban, String tacgia, String nhaxuatban, String theloai, String soluong) {

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

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        GiaNhap = giaNhap;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
