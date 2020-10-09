package com.example.quanlysachphuongnam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysachphuongnam.Adapter.Adapter_NguoiDung;
import com.example.quanlysachphuongnam.Model.NguoiDung;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class QuanLyNguoiDungActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btn_SUA,btn_HUY,btn_huy,btn_Xoa;
    Button btn_sua1,btn_xoa1;
    EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    Adapter_NguoiDung adapter_nguoiDung;
    EditText editText1,editText2;
    List<NguoiDung> nguoiDungList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nguoi_dung);
        anhxa();
        nguoiDungList = new ArrayList<>();
        recyclerView = findViewById(R.id.RCV_QLND);
        adapter_nguoiDung = new Adapter_NguoiDung(DangKyActivity.nguoiDungList,this,R.layout.recycle_qlnd);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter_nguoiDung);
        btn_sua1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogSuaNguoiDung();
            }
        });
        btn_xoa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_xoanguoidung();
            }
        });

    }
    //dia log sủa người dùng
    public  void DialogSuaNguoiDung(){
         final Dialog dialog = new Dialog(this);
         dialog.setContentView(R.layout.activity_sua_nguoi_dung);
         txt1= dialog.findViewById(R.id.suaND_hoten);
         txt2 = dialog.findViewById(R.id.suaND_user);
         txt3 = dialog.findViewById(R.id.suaND_pass);
         txt6 = dialog.findViewById(R.id.suaND_sdt);
         btn_SUA = dialog.findViewById(R.id.btn_sua_nd);
         btn_HUY = dialog.findViewById(R.id.btn_huy_nd1);
         btn_SUA.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String hoten = txt1.getText().toString().trim();
                 String user =txt2.getText().toString().trim();
                 String pass = txt3 .getText().toString().trim();
                 String sdt = txt6.getText().toString().trim();

                 if (Adapter_NguoiDung.position == -1){
                     dialog.cancel();
                 }else {
                     nguoiDungList.remove(Adapter_NguoiDung.position);
                     nguoiDungList.add(Adapter_NguoiDung.position, new NguoiDung(hoten,user,pass,sdt));
                     adapter_nguoiDung.notifyItemChanged(Adapter_NguoiDung.position);
                     Adapter_NguoiDung.position = -1;
                     Toast.makeText(QuanLyNguoiDungActivity.this, "Sủa Người Dùng Thành công", Toast.LENGTH_SHORT).show();

                 }
             }
         });
         btn_HUY.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dialog.cancel();
             }
         });
         dialog.show();

    }
    //dialog xóa người dùng
    public  void Dialog_xoanguoidung(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_xoa_nguoi_dung);
        btn_huy = dialog.findViewById(R.id.btn_huy_nd);
        editText1 = dialog.findViewById(R.id.edt_xoanguoidung);
        btn_Xoa = dialog.findViewById(R.id.btn_xoa_ma_nd);
        btn_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaNguoiDung(editText1.getText().toString().trim());
                Toast.makeText(QuanLyNguoiDungActivity.this, "Xóa Người Dùng Thành công", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
       dialog.show();

    }
    // hãm xóa theo  index
    public  void XoaNguoiDung(String id){
        for (int i = 0; i < nguoiDungList.size(); i++) {
            if (id.equals(nguoiDungList.get(i).getHoTen())) {
                nguoiDungList.remove(i);
            }
        }
        adapter_nguoiDung.notifyDataSetChanged();
    }
    private void anhxa() {
        btn_sua1 = findViewById(R.id.sua_ND);
        btn_xoa1 = findViewById(R.id.xoa_ND);
    }

































//    //option menu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.item_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId()==R.id.caidat){
//            Toast.makeText(QuanLyNguoiDungActivity.this,"cài dặt ",Toast.LENGTH_LONG).show();
//        }
//        else if(item.getItemId()==R.id.caidat1){
//            Toast.makeText(QuanLyNguoiDungActivity.this,"Cài Đặt 1",Toast.LENGTH_LONG).show();
//        }else  if (item.getItemId()==R.id.caidat2){
//            Toast.makeText(QuanLyNguoiDungActivity.this,"liên hệ chúng tôi",Toast.LENGTH_LONG).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
