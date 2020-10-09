package com.example.quanlysachphuongnam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Adapter.Adapter_NguoiDung;
import com.example.quanlysachphuongnam.Model.NguoiDung;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class DangKyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter_NguoiDung adapter_nguoiDung;
  public  static   List<NguoiDung> nguoiDungList;
    TextInputEditText edt1,edt2,edt3,edt4,edt5,edt6,edt7;
    Button buttonDangKy, buttonThoat;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        buttonDangKy = (Button) findViewById(R.id.button_dangky);
        buttonThoat = (Button) findViewById(R.id.button_Thoat_dk);
        nguoiDungList = new ArrayList<>();
        edt1 = findViewById(R.id.edt_hoten_nd);
        edt2 = findViewById(R.id.edt_username_nd);
        edt3 = findViewById(R.id.edt_password_nd);
        edt6 = findViewById(R.id.edt_sodienthoai_nd);
//        nguoiDungList = new ArrayList<>();
       recyclerView = findViewById(R.id.RCV_QLND);


        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DangKyActivity.this, DangNhapActivity.class);
                startActivity(a);

            }
        });
        buttonDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edt1.getText().toString().trim();
                String user = edt2.getText().toString().trim();
                String pass = edt3.getText().toString().trim();
                String sdt = edt6.getText().toString().trim();
                nguoiDungList.add(new NguoiDung(hoten,user,pass,sdt));
//                adapter_nguoiDung.notifyDataSetChanged();
                Toast.makeText(DangKyActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_LONG).show();
                Intent b = new Intent(DangKyActivity.this, QuanLyNguoiDungActivity.class);
                startActivity(b);

            }
        });


    }


}