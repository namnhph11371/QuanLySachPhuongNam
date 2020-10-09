package com.example.quanlysachphuongnam;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Adapter.Adapter_Sach;
import com.example.quanlysachphuongnam.Model.Sach;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class QuanLySachActivity extends AppCompatActivity {
    Button btnthem, btnsua, btnxoa, btnXoa, btnHuy;
    Button btnSuaSach, btnHuySach;
    RecyclerView recyclerView;
    List<Sach> sachList;
    Adapter_Sach adapter_sach;
    TextInputEditText txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    EditText edt_xoa, edt1, edt2, edt3, edt4, edt5, edt6, edt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sach);
        anhxa();
        sachList = new ArrayList<>();
        //danh sách ảo
        recyclerView = findViewById(R.id.RCV_Sach);
        adapter_sach = new Adapter_Sach(sachList, this, R.layout.recycle_sach);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter_sach);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masach = txt1.getText().toString().trim();
                String theloai = txt6.getText().toString().trim();
                String tensach = txt2.getText().toString().trim();
                String tacgia = txt4.getText().toString().trim();
                String nhaxuatban = txt5.getText().toString().trim();
                String giaban = txt3.getText().toString().trim();
                String soluong = txt7.getText().toString().trim();
                Sach sach = new Sach(masach, theloai, tensach, tacgia, nhaxuatban, Float.parseFloat(giaban), Float.parseFloat(soluong));
                sachList.add(sach);
                adapter_sach.notifyDataSetChanged();
            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLogSuaSach();

            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLogXoaSach();

            }
        });


    }

    // dialog sửa sách
    public void DiaLogSuaSach() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_sua_sach);
        edt1 = dialog.findViewById(R.id.suasach_MaSach);
        edt6 = dialog.findViewById(R.id.suasach_theloai);
        edt2 = dialog.findViewById(R.id.suasach_tensach);
        edt4 = dialog.findViewById(R.id.suasach_tacgia);
        edt5 = dialog.findViewById(R.id.suasach_nhaxuatban);
        edt3 = dialog.findViewById(R.id.suasach_giaban);
        edt7 = dialog.findViewById(R.id.suasach_soluong);
        btnSuaSach = dialog.findViewById(R.id.btn_suasach);
        btnHuySach = dialog.findViewById(R.id.btn_huysuasach);
        btnSuaSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masach = edt1.getText().toString().trim();
                String theloai = edt6.getText().toString().trim();
                String tensach = edt2.getText().toString().trim();
                String tacgia = edt4.getText().toString().trim();
                String nhaxuatban = edt5.getText().toString().trim();
                String giaban = edt3.getText().toString().trim();
                String soluong = edt7.getText().toString().trim();
                if (Adapter_Sach.position == -1) {
                    dialog.cancel();
                } else {
                    sachList.remove(Adapter_Sach.position);
                    sachList.add(Adapter_Sach.position, new Sach(masach, theloai, tensach, tacgia, nhaxuatban, Float.parseFloat(giaban), Float.parseFloat(soluong)));
                    adapter_sach.notifyItemChanged(Adapter_Sach.position);
                    Adapter_Sach.position = -1;
                    dialog.cancel();
                }

            }
        });
        btnHuySach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    // dialog xóa sách
    private void DiaLogXoaSach() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_xoa_sach);
        edt_xoa = dialog.findViewById(R.id.edt_xoasach);
        btnXoa = dialog.findViewById(R.id.btn_xoasach);
        btnHuy = dialog.findViewById(R.id.btn_huy);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoasach(edt_xoa.getText().toString().trim());
                dialog.cancel();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();

    }

    private void anhxa() {
        txt1 = findViewById(R.id.textMaSach);

        txt2 = findViewById(R.id.textTenSach);
        txt3 = findViewById(R.id.textGiaBan);
        txt4 = findViewById(R.id.textTacGia);
        txt5 = findViewById(R.id.textNhaXuatBan);
        txt6 = findViewById(R.id.textTheLoai);
        txt7 = findViewById(R.id.textSoLuong);
        btnthem = findViewById(R.id.button_QLS_Them);
        btnsua = findViewById(R.id.button_QLS_SUA);
        btnxoa = findViewById(R.id.button_QLS_Xoa);
        recyclerView = findViewById(R.id.RCV_Sach);
    }

    public void xoasach(String id) {
        for (int i = 0; i < sachList.size(); i++) {
            if (id.equals(sachList.get(i).getMaSach())) {
                sachList.remove(i);
            }
        }
        adapter_sach.notifyDataSetChanged();
    }


//
}
