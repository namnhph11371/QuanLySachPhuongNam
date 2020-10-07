package com.example.quanlysachphuongnam.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlite extends SQLiteOpenHelper {
    public  MySqlite(Context context){
        super(context,"data.sql",null,1);
    }
    // khi khoi tao bang
    @Override
    public void onCreate(SQLiteDatabase db) {
      String table_QLND = "create table QLND" + "(UserName NVARCHAR(50) primary key NOT NULL,PassWord NVARCHAR(50) NOT NULL,SoDienThoai NVARCHAR,Hoten NVARCHAR)";
      String table_QLS = "create table QLS" +"(MaSach NVARCHAR(50) primary key NOT NULL,MaTheLoai NVARCHAR(50) NOT NULL,TenSach NVARCHAR(50) NOT NULL,GiaNhap Float NOT NULL,TieuDe NVARCHAR NOT NULL,TacGia NVARCHAR NOT NULL,NhaXuatBan NVARCHAR NOT NULL,GiaBan Float NOT NULL,SoLuong INT NOT NULL)";
      String table_QLHD = "create table QLHD"+"(MaHoaDon NVARCHAR(50) primary key NOT NULL,NgayMua NVARCHAR NOT NULL)";
      String table_QLTL = "create table QLTL"+"(MaSach  NVARCHAR(50) primary key NOT NULL,TenSach NVARCHAR NOT NULL,TheLoai NVARCHAR NOT NULL,TacGia NVARCHAR NOT NULL,NhaXuatBan NVARCHAR NOT NULL)";
      String table_HDCT = "create table HDCT"+"(MaHoaDonChiTiet NVARCHAR(50) primary key NOT NULL,MaHoaDon NVARCHAR(50) NOT NULL,NgayMua NVARCHAR NOT NULL,TenNguoiMua NVARCHAR NOT NULL,TenNguoiBan NVARCHAR NOT NULL,TenSach  NVARCHAR NOT NULL,SoLuongMua Int NOT NULL,DiaChiNguoiMua NVARCHAR NOT NULL,TongTien Float NOT NULL,ThanhToan Double NOT NULL)";
      db.execSQL(table_QLND);
      db.execSQL(table_QLS);
      db.execSQL(table_QLHD);
      db.execSQL(table_HDCT);
      db.execSQL(table_QLTL);
    }

    // cap nhap cau truc csdl
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
