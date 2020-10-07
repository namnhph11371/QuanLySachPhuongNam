package com.example.quanlysachphuongnam.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.Model.HoaDon;
import com.example.quanlysachphuongnam.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class QLHD_DAO {
    private MySqlite mySqlite;
    public QLHD_DAO(MySqlite mySqlite){
        this.mySqlite = mySqlite;
    }
    // hàm thêm
    public  void Insert_QLHD(HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHoaDon",hoaDon.getMaHoaDon());
        contentValues.put("NgayMua",hoaDon.getNgayMua());
        sqLiteDatabase.insert("QLHD",null,contentValues);
    }
    // hàm sửa
    public  void Update_QLHD(HoaDon hoaDon,String MaHoaDon){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHoaDon",hoaDon.getMaHoaDon());
        contentValues.put("NgayMua",hoaDon.getNgayMua());
        sqLiteDatabase.update("QLHD",contentValues,"MaHoaDon=?",new String[]{
                MaHoaDon
        });

    }
    // hàm xóa
    public  void Delete_QLHD(HoaDon hoaDon,String MaHoaDon){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        sqLiteDatabase.delete("QLHD","MaHoaDon",new String[]{
                MaHoaDon
        });
    }
    // hàm lấy danh sách
    public List<HoaDon> getAll_QLHD(){
        List<HoaDon> hoaDonList = new ArrayList<>();
        String TruyVan_HD = "SELECT *FROM HOADON";
        Cursor cursor = mySqlite.getWritableDatabase().rawQuery(TruyVan_HD,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                String Mahoadon = cursor.getString(cursor.getColumnIndex("MaHoaDon"));
                String Ngaymua = cursor.getString(cursor.getColumnIndex("NgayMua"));
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(Mahoadon);
                hoaDon.setNgayMua(Ngaymua);
                hoaDonList.add(hoaDon);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoaDonList;

    }
}
