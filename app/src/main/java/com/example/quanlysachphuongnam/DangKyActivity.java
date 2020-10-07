package com.example.quanlysachphuongnam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DangKyActivity extends AppCompatActivity {
 Button buttonDangKy,buttonThoat,buttonlayanh;
 ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        buttonDangKy = (Button) findViewById(R.id.button_dangky);
        buttonThoat = (Button) findViewById(R.id.button_Thoat);
        buttonlayanh = (Button) findViewById(R.id.button_layanh);
        imageView = (ImageView) findViewById(R.id.img_Dangky);
        buttonlayanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, 123);
                } else {
                    ActivityCompat.requestPermissions(DangKyActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1234);

                }
            }
        });
        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DangKyActivity.this,DangNhapActivity.class);
                startActivity(a);

            }
        });
        buttonDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DangKyActivity.this,"Đăng Ký Thành Công",Toast.LENGTH_LONG).show();
               Intent b = new Intent(DangKyActivity.this,QuanLyNguoiDungActivity.class);
               startActivity(b);

            }
        });


    }
Bitmap bm;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && requestCode == 123 && resultCode == RESULT_OK) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = getContentResolver().openInputStream(data.getData());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bm = BitmapFactory.decodeStream(inputStream);
                if (inputStream != null) {
                    imageView.setImageBitmap(bm);
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}