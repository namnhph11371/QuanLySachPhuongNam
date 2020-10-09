package com.example.quanlysachphuongnam.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.Model.NguoiDung;
import com.example.quanlysachphuongnam.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class QLS_DAO {
    private MySqlite mySqlite;
    SQLiteDatabase QLS;
    public QLS_DAO(MySqlite mySqlite){
        this.mySqlite = mySqlite;

    }
    // hàm thêm
    public void insertQLS(Sach sach){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSach",sach.getMaSach());
        contentValues.put("MaTheLoai",sach.getMaTheLoai());
        contentValues.put("TenSach",sach.getTenSach());
        contentValues.put("TacGia",sach.getTacGia());
        contentValues.put("NhaXuatBan",sach.getNhaXuatban());
        contentValues.put("GiaBan",sach.getGiaBan());
        contentValues.put("SoLuong",sach.getSoLuong());
        sqLiteDatabase.insert("QLS",null,contentValues);
    }
    // hàm sửa
    public  void UpdateQLS(Sach sach,String MaSach){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSach",sach.getMaSach());
        contentValues.put("MaTheLoai",sach.getMaTheLoai());
        contentValues.put("TenSach",sach.getTenSach());
        contentValues.put("TacGia",sach.getTacGia());
        contentValues.put("NhaXuatBan",sach.getNhaXuatban());
        contentValues.put("GiaBan",sach.getGiaBan());
        contentValues.put("SoLuong",sach.getSoLuong());
        sqLiteDatabase.update("QLS",contentValues,"MaSach=?",new String[]{
            MaSach
        });
    }
    // hàm xóa
    public  void deleteQLS(String MaSach){
       SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
       sqLiteDatabase.delete("QLS","MaSach=?",new String[]{MaSach});
    }
    // hàm lấy danh sách
    public List<Sach> getAll_QLS(){
       List<Sach> sachList = new ArrayList<>();
        String TruyVan_Sach = "SELECT * FROM QLS";
        Cursor cursor = mySqlite.getWritableDatabase().rawQuery(TruyVan_Sach,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()==false){
                String MaSach = cursor.getString(cursor.getColumnIndex("MaSach"));
                String MaTheLoai = cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                String TenSach = cursor.getString(cursor.getColumnIndex("TenSach"));
                String TacGia = cursor.getString(cursor.getColumnIndex("TacGia"));
                String NhaXuatBan = cursor.getString(cursor.getColumnIndex("NhaXuatBan"));
                String GiaBan = cursor.getString(cursor.getColumnIndex("GiaBan"));
                String SoLuong = cursor.getString(cursor.getColumnIndex("SoLuong"));
                Sach sach = new Sach();
                sach.setMaSach(MaSach);
                sach.setMaTheLoai(MaTheLoai);
                sach.setTenSach(TenSach);
                sach.setTacGia(TacGia);
                sach.setNhaXuatban(NhaXuatBan);
                sach.setGiaBan(Float.parseFloat(GiaBan));
                sach.setSoLuong(Integer.parseInt(SoLuong));
                sachList.add(sach);
                cursor.moveToNext();

            }
            cursor.close();
        }
        return sachList;

    }
}
