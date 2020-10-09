package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysachphuongnam.Adapter.Adapter_TheLoai;
import com.example.quanlysachphuongnam.Model.TheLoai;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTheLoaiActivity extends AppCompatActivity {
 Button btnthem,btnsua,btnxoa,btnXoa,btnHuy;
 Button btnsuatheloai,btnhuysuatheloai;
 TextInputEditText txt1,txt2,txt3,txt4,txt5;
 RecyclerView recyclerView;
 List<TheLoai> theLoaiList;
 Adapter_TheLoai adapter_theLoai;
 EditText editText,edt1,edt2,edt3,edt4,edt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_the_loai);
        anhxa();
       recyclerView = findViewById(R.id.RCV_QLTL);
       theLoaiList = new ArrayList<>();
       adapter_theLoai = new Adapter_TheLoai(theLoaiList,this,R.layout.recycle_theloai);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(adapter_theLoai);
       btnthem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String ma = txt1.getText().toString().trim();
               String ten = txt2.getText().toString().trim();
               String theloai = txt3.getText().toString().trim();
               String tacgia = txt4.getText().toString().trim();
               String nhaxuatban = txt5.getText().toString().trim();
               theLoaiList.add(new TheLoai(ma,ten,theloai,tacgia,nhaxuatban));
               adapter_theLoai.notifyDataSetChanged();
               Toast.makeText(QuanLyTheLoaiActivity.this, "thêm thành công", Toast.LENGTH_SHORT).show();
           }
       });
       btnsua.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DiaLogSuaTheLoai();
//               Toast.makeText(QuanLyTheLoaiActivity.this, "sửa thành công", Toast.LENGTH_SHORT).show();

           }
       });
       btnxoa.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DialogXoaTheLoai();
//               Toast.makeText(QuanLyTheLoaiActivity.this, "xóa thành công", Toast.LENGTH_SHORT).show();
           }
       });
    }

     // dialog sua the loai
    private  void DiaLogSuaTheLoai(){
        final  Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_sua_the_loai);
        edt1 = dialog.findViewById(R.id.sua_masach_tl);
        edt2 = dialog.findViewById(R.id.sua_tensach_tl);
        edt3 = dialog.findViewById(R.id.sua_theloai_tl);
        edt4 = dialog.findViewById(R.id.sua_tacgia_tl);
        edt5 = dialog.findViewById(R.id.sua_nhaxuatban_tl);
        btnsuatheloai = dialog.findViewById(R.id.btn_Sua_TL);
        btnhuysuatheloai = dialog.findViewById(R.id.btn_Huysua_TL);
        btnsuatheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = edt1.getText().toString().trim();
                String ten = edt2.getText().toString().trim();
                String theloai = edt3.getText().toString().trim();
                String tacgia = edt4.getText().toString().trim();
                String nhaxuatban = edt5.getText().toString().trim();
                if (Adapter_TheLoai.position==-1){

                }else {
                    theLoaiList.remove(Adapter_TheLoai.position);
                    theLoaiList.add(Adapter_TheLoai.position, new TheLoai(ma, ten,theloai,tacgia,nhaxuatban));
                    adapter_theLoai.notifyItemChanged(Adapter_TheLoai.position);
                    Adapter_TheLoai.position = -1;
                    Toast.makeText(QuanLyTheLoaiActivity.this, "Sửa Hóa Đơn Thành Công", Toast.LENGTH_SHORT).show();
                    dialog.cancel();

                }

            }
        });
        btnhuysuatheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.cancel();
            }
        });
        dialog.show();

    }
     // dialog xóa thể loại
    private  void DialogXoaTheLoai(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_xoa_the_loai);
        editText = dialog.findViewById(R.id.edt_xoathloai);
        btnXoa = dialog.findViewById(R.id.btn_xoatheloai);
        btnHuy = dialog.findViewById(R.id.btn_huytheloai);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoatheloai(editText.getText().toString().trim());
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
    public  void xoatheloai(String id){
        for (int i=0;i <theLoaiList.size();i++){
            if (id.equals(theLoaiList.get(i).getMaSach())){
                theLoaiList.remove(i);
            }
        }
        adapter_theLoai.notifyDataSetChanged();
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

}
