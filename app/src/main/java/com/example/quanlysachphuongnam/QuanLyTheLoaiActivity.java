package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlysachphuongnam.Adapter.Adapter_TheLoai;
import com.example.quanlysachphuongnam.Model.TheLoai;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTheLoaiActivity extends AppCompatActivity {
 Button btnthem,btnsua,btnxoa,btnXoa,btnHuy;
 TextInputEditText txt1,txt2,txt3,txt4,txt5;
 RecyclerView recyclerView;
 List<TheLoai> theLoaiList;
 Adapter_TheLoai adapter_theLoai;
 EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_the_loai);
        anhxa();
        theLoaiList = new ArrayList<>();
        adapter_theLoai = new Adapter_TheLoai(theLoaiList,this,R.layout.recycle_theloai);
        recyclerView.setAdapter(adapter_theLoai);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void anhxa() {
        txt1 = findViewById(R.id.txtmasach_tl);
        txt2 = findViewById(R.id.txttensach_tl);
        txt3 = findViewById(R.id.txttheloai_tl);
        txt4 = findViewById(R.id.txttacgia_tl);
        txt5 = findViewById(R.id.txtnhaxuatban_tl);
        btnthem = findViewById(R.id.button_QLTL_Them);
        btnsua = findViewById(R.id.button_QLTL_Sua);
        btnxoa = findViewById(R.id.button_QLTL_Xoa);
    }

    private  void DialogXoaTheLoai(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_xoa_the_loai);
        editText = dialog.findViewById(R.id.edt_xoathloai);
        btnXoa = dialog.findViewById(R.id.btn_xoatheloai);
        btnHuy = dialog.findViewById(R.id.btn_huytheloai);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    }
    public  void xoatheloai(){
        
    }

}
