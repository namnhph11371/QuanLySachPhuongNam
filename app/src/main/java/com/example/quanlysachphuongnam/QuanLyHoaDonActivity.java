package com.example.quanlysachphuongnam;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Adapter.Adapter_HoaDon;
import com.example.quanlysachphuongnam.Database.MySqlite;
import com.example.quanlysachphuongnam.Database.QLHD_DAO;
import com.example.quanlysachphuongnam.Model.HoaDon;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QuanLyHoaDonActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter_HoaDon adapter_hoaDon;
    List<HoaDon> hoaDonList;
    Button btnthem, btnsua, btnxoa, btnxoahoadon, btnhuy, btnsuahd, btnhuyhd;
    TextInputEditText text1, text2;
    EditText editText, edt_xoa, sua_mhd, sua_ngaymua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_hoa_don);
        final MySqlite mySqlite = new MySqlite(getApplicationContext());
        // khai báo sql
        final QLHD_DAO qlhdDao = new QLHD_DAO(mySqlite);
        anhxa();
        hoaDonList = new ArrayList<>();
//        hoaDonList.add(new HoaDon("hd001", "11/12/2018"));
//        hoaDonList.add(new HoaDon("hd002", "11/12/2018"));
//        hoaDonList.add(new HoaDon("hd003", "11/12/2018"));
//        hoaDonList.add(new HoaDon("hd004", "11/12/2018"));
//        hoaDonList.add(new HoaDon("hd005", "11/12/2018"));
        recyclerView = findViewById(R.id.rcv_hd);
        adapter_hoaDon = new Adapter_HoaDon(hoaDonList, this, R.layout.recycle_hoadon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter_hoaDon);
        text1 = findViewById(R.id.textMa);
        editText = findViewById(R.id.edt_NgayMua);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = text1.getText().toString().trim();
                String ngaymua = editText.getText().toString().trim();
                editText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chonngay();
                    }
                });
                hoaDonList.add(new HoaDon(ma, ngaymua));
               // qlhdDao.Insert_QLHD();
                adapter_hoaDon.notifyDataSetChanged();
                Toast.makeText(QuanLyHoaDonActivity.this, "Thêm Hóa Đơn Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DiaLogSuaHD();

            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogXoaHD();

            }
        });

    }

    // dialog sửa hóa đơn
    private void DiaLogSuaHD() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_sua_hoa_don);
        sua_mhd = dialog.findViewById(R.id.sua_mahoa_Hd);
        sua_ngaymua = dialog.findViewById(R.id.sua_chonngay_Hd);
        btnsuahd = dialog.findViewById(R.id.btn_sua_hd);
        btnhuyhd = dialog.findViewById(R.id.btn_huy_hd);
        btnsuahd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = sua_mhd.getText().toString().trim();
                String ngay = sua_ngaymua.getText().toString().trim();

                if (Adapter_HoaDon.position == -1) {
                    // khi chưa ấn vào hàng cần sửa
//                    Toast.makeText(QuanLyHoaDonActivity.this, "werewr", Toast.LENGTH_SHORT).show();


                } else {
                    hoaDonList.remove(Adapter_HoaDon.position);
                    hoaDonList.add(Adapter_HoaDon.position, new HoaDon(ma, ngay));
                    adapter_hoaDon.notifyItemChanged(Adapter_HoaDon.position);
                    Adapter_HoaDon.position = -1;
                    Toast.makeText(QuanLyHoaDonActivity.this, "Sửa Hóa Đơn Thành Công", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }

            }

        });
        btnhuyhd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();

    }

    //dialog xóa hóa đơn
    private void DialogXoaHD() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_xoa_hoa_don);
        btnhuy = dialog.findViewById(R.id.btn_huy);
        edt_xoa = dialog.findViewById(R.id.edt_xoahoadon);
        btnxoahoadon = dialog.findViewById(R.id.btn_xoahoadon);
        btnxoahoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoahoadon(edt_xoa.getText().toString().trim());
                Toast.makeText(QuanLyHoaDonActivity.this, "Xóa Hóa Đơn Thành công", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    //dateTimePicker
    public void chonngay() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(calendar.DATE);
        int thang = calendar.get(calendar.MONTH);
        int nam = calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mmm/yyyy");
                editText.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, 2017, 01, 01);
        datePickerDialog.show();
    }

    private void anhxa() {

        btnthem = (Button) findViewById(R.id.button_QLHD_THEM);
        btnsua = (Button) findViewById(R.id.button_QLHD_SUA);
        btnxoa = (Button) findViewById(R.id.button_QLHD_XOA);
    }
    // hàm sửa hóa đơn


    //hàm xóa id hóa đơn
    public void xoahoadon(String id) {
        for (int i = 0; i < hoaDonList.size(); i++) {
            if (id.equals(hoaDonList.get(i).getMaHoaDon())) {
                hoaDonList.remove(i);
            }
        }
        adapter_hoaDon.notifyDataSetChanged();
    }


}
