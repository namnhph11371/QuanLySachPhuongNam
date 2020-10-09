package com.example.quanlysachphuongnam.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.Model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class QLND_DAO {
    private MySqlite mySqlite;
    public QLND_DAO(MySqlite mySqlite){
        this.mySqlite = mySqlite;
    }
    //them nd
    public  void insertND(NguoiDung ND){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserName",ND.getUserName());
        contentValues.put("PassWord",ND.getPassWord());
        contentValues.put("Họ Và Tên",ND.getHoTen());
        contentValues.put("Số điện Thoại",ND.getSoDienThoai());
        sqLiteDatabase.insert("QLND",null,contentValues);
    }
    // sua nd
    public  void  UpdateND(NguoiDung ND,String user){
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserName",ND.getUserName());
        contentValues.put("PassWord",ND.getPassWord());
        contentValues.put("Họ Và Tên",ND.getHoTen());
        contentValues.put("Số Điện Thoại",ND.getSoDienThoai());
        sqLiteDatabase.update("QLND",contentValues,"UserName=?", new String[]{
                user
        });
    }
    // xoa nd
    public  void  DeleteND(NguoiDung ND, String user){
        SQLiteDatabase  sqLiteDatabase = mySqlite.getWritableDatabase();
        sqLiteDatabase.delete("QLND","UserName=?",new String[]{
                user
        });
   }
    // lay danh sach
    public List<NguoiDung> getAllNguoiDung(){
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String truyVanND = "SELECT * FROM QLND";
        Cursor cursor = mySqlite.getWritableDatabase().rawQuery(truyVanND,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()==false){
                String userName = cursor.getString(cursor.getColumnIndex("UserName"));
                String pasWord = cursor.getString(cursor.getColumnIndex("PassWord"));
                String HoTen = cursor.getString(cursor.getColumnIndex("HoTen"));
                String SoDienThoai = cursor.getString(cursor.getColumnIndex("SoDienThoai"));

               NguoiDung nguoiDung= new NguoiDung();
               nguoiDung.setUserName(userName);
               nguoiDung.setPassWord(pasWord);
               nguoiDung.setHoTen(HoTen);
               nguoiDung.setSoDienThoai(SoDienThoai);
               nguoiDungList.add(nguoiDung);
               cursor.moveToNext();
            }
            cursor.close();
        }
        return nguoiDungList;
    }
    // tìm kiếm người dùng
    public  List<NguoiDung> timkiemUsername(String timkiemusername){
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM USER WHERE username LIKE '%" +timkiemusername + "%'";
        Cursor cursor = mySqlite.getWritableDatabase().rawQuery(sql,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String userName = cursor.getString(cursor.getColumnIndex("UserName"));
                String pasWord = cursor.getString(cursor.getColumnIndex("PassWord"));
                String HoTen = cursor.getString(cursor.getColumnIndex("HoTen"));
                String SoDienThoai = cursor.getString(cursor.getColumnIndex("SoDienThoai"));

                NguoiDung nguoiDung= new NguoiDung();
                nguoiDung.setUserName(userName);
                nguoiDung.setPassWord(pasWord);
                nguoiDung.setHoTen(HoTen);
                nguoiDung.setSoDienThoai(SoDienThoai);
                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }

        }
        return nguoiDungList;
    }




}
