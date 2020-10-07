package com.example.quanlysachphuongnam.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.Model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class HDCT_DAO {
    private MySqlite mySqlite;
    public HDCT_DAO(MySqlite mySqlite){
        this.mySqlite = mySqlite;
    }
    // hàm thêm
    public  void insert_HDCT(HoaDonChiTiet hoaDonChiTiet){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHoaDonChiTiet",hoaDonChiTiet.getMaHoaDonChiTiet());
        contentValues.put("MaHoaDon",hoaDonChiTiet.getMaHoaDon());
        contentValues.put("NgayMua",hoaDonChiTiet.getNgayMua());
        contentValues.put("TenNguoiBan",hoaDonChiTiet.getTenNguoiBan());
        contentValues.put("TenNguoiMua",hoaDonChiTiet.getTenNguoiMua());
        contentValues.put("TenSach",hoaDonChiTiet.getTenSach());
        contentValues.put("SoLuongMua",hoaDonChiTiet.getSoLuongMua());
        contentValues.put("DiaChiNguoiMua",hoaDonChiTiet.getDiaChiNguoiMua());
        contentValues.put("TongTien",hoaDonChiTiet.getTongTien());
        contentValues.put("ThanhToan",hoaDonChiTiet.getThanhToan());
        sqLiteDatabase.insert("HDCT",null,contentValues);
    }
    // hàm sửa
    public  void Update_HDCT(String MaHoaDonChiTiet,HoaDonChiTiet hoaDonChiTiet){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHoaDonChiTiet",hoaDonChiTiet.getMaHoaDonChiTiet());
        contentValues.put("MaHoaDon",hoaDonChiTiet.getMaHoaDon());
        contentValues.put("NgayMua",hoaDonChiTiet.getNgayMua());
        contentValues.put("TenNguoiBan",hoaDonChiTiet.getTenNguoiBan());
        contentValues.put("TenNguoiMua",hoaDonChiTiet.getTenNguoiMua());
        contentValues.put("TenSach",hoaDonChiTiet.getTenSach());
        contentValues.put("SoLuongMua",hoaDonChiTiet.getSoLuongMua());
        contentValues.put("DiaChiNguoiMua",hoaDonChiTiet.getDiaChiNguoiMua());
        contentValues.put("TongTien",hoaDonChiTiet.getTongTien());
        contentValues.put("ThanhToan",hoaDonChiTiet.getThanhToan());
        sqLiteDatabase.update("HDCT",contentValues,"MAHOADONCHITIET=?",new String[]{
                MaHoaDonChiTiet
        });
    }
    // hàm xóa
    public  void Delete_HDCT(HoaDonChiTiet hoaDonChiTiet,String MaHoaDonChiTiet){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        sqLiteDatabase.delete("HDCT","MAHOADONCHITIET",new String[]{
                MaHoaDonChiTiet
        });
    }
    // hàm lấy danh sách
    public List<HoaDonChiTiet> getAll_HDCT(){
        List<HoaDonChiTiet> hoaDonChiTietList= new ArrayList<>();
        String TruyVan_HDCT ="SELECT *FROM HDCT";
        Cursor cursor = mySqlite.getWritableDatabase().rawQuery(TruyVan_HDCT,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()==false){
                String Mahoadonchitiet =  cursor.getString(cursor.getColumnIndex("MaHoaDonChiTiet"));
                String MaHoaDon = cursor.getString(cursor.getColumnIndex("MaHoaDonChiTiet"));
                String NgayMua = cursor.getString(cursor.getColumnIndex("NgayMua"));
                String TenNguoiBan = cursor.getString(cursor.getColumnIndex("TenNguoiBan"));
                String TenNguoiMua = cursor .getString(cursor.getColumnIndex("TenNguoiMua"));
                String TenSach = cursor.getString(cursor.getColumnIndex("TenSach"));
                String SoLuongMua = cursor.getString(cursor.getColumnIndex("SoLuongMua"));
                String DiaChiNguoiMua = cursor.getString(cursor.getColumnIndex("DiaChiNguoiMua"));
                String TongTien = cursor.getString(cursor.getColumnIndex("TongTien"));
                String ThanhToan = cursor.getString(cursor.getColumnIndex("ThanhToan"));
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setMaHoaDonChiTiet(Mahoadonchitiet);
                hoaDonChiTiet.setMaHoaDon(MaHoaDon);
                hoaDonChiTiet.setNgayMua(NgayMua);
                hoaDonChiTiet.setTenNguoiBan(TenNguoiBan);
                hoaDonChiTiet.setTenNguoiMua(TenNguoiMua);
                hoaDonChiTiet.setTenNguoiBan(TenSach);
                hoaDonChiTiet.setSoLuongMua(Integer.parseInt(SoLuongMua));
                hoaDonChiTiet.setDiaChiNguoiMua(DiaChiNguoiMua);
                hoaDonChiTiet.setTongTien(Float.parseFloat(TongTien));
                hoaDonChiTiet.setThanhToan(Double.valueOf(ThanhToan));
                hoaDonChiTietList.add(hoaDonChiTiet);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoaDonChiTietList;

    }
}
