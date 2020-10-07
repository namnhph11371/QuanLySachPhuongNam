package com.example.quanlysachphuongnam.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class QLTL_DAO {
    private MySqlite mySqlite;
    public QLTL_DAO(MySqlite mySqlite){
        this.mySqlite = mySqlite;
    }
    // hàm thêm
    public  void insert_QLTL(TheLoai theLoai){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSach ",theLoai.getMaSach());
        contentValues.put("TenSach",theLoai.getTenSach());
        contentValues.put("TheLoai",theLoai.getTheLoai());
        contentValues.put("TacGia",theLoai.getNhaXuatBan());
        contentValues.put("NhaXuatBan",theLoai.getNhaXuatBan());
        sqLiteDatabase.insert("QLTL",null,contentValues);

    }
    // hàm sửa
    public void Update_QLTL(TheLoai theLoai,String TenSach){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSach",theLoai.getMaSach());
        contentValues.put("TenSach",theLoai.getTenSach());
        contentValues.put("TheLoai",theLoai.getTheLoai());
        contentValues.put("TacGia",theLoai.getNhaXuatBan());
        contentValues.put("NhaXuatBan",theLoai.getNhaXuatBan());
        sqLiteDatabase.update("QLTL",contentValues,"MaSach=?",new String[]{
                TenSach
        });
    }
    // hàm xóa
    public  void Delete_QLTL(TheLoai theLoai,String Masach){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        sqLiteDatabase.delete("QLTL","MaSach=?",new String[]{
                Masach
        });

    }
    // hàm lấy danh sách
    public List<TheLoai> getAll_QLTL(){
        List<TheLoai> theLoaiList = new ArrayList<>();
        String  TruyVan_QLTL = "SELECT * FROM TheLoai";
        Cursor cursor = mySqlite.getWritableDatabase().rawQuery(TruyVan_QLTL,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()==false){
                String Masach = cursor.getString(cursor.getColumnIndex("MaSach"));
                String Tensach = cursor.getString(cursor.getColumnIndex("TenSach"));
                String Theloai = cursor.getString(cursor.getColumnIndex("TheLoai"));
                String Tacgia = cursor.getString(cursor.getColumnIndex("TacGia"));
                String Nhaxuatban = cursor.getString(cursor.getColumnIndex("NhaXuatBan"));
                TheLoai theLoai = new TheLoai();
                theLoai.setMaSach(Masach);
                theLoai.setTenSach(Tensach);
                theLoai.setTheLoai(Theloai);
                theLoai.setTacGia(Tacgia);
                theLoai.setNhaXuatBan(Nhaxuatban);
                theLoaiList.add(theLoai);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return  theLoaiList;
    }
}
