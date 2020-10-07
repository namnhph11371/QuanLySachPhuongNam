package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DangNhapActivity extends AppCompatActivity {
    Button btndangnhap,btndangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        btndangnhap = (Button) findViewById(R.id.btnDangNhap_DN);
        btndangky = (Button) findViewById(R.id.btnDangKy_DN);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DangNhapActivity.this,TrangChuActivity.class);
                startActivity(i);

            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(y);
            }
        });

    }
}
