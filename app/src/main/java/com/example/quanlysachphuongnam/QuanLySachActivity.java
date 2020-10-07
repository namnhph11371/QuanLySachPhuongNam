package com.example.quanlysachphuongnam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysachphuongnam.Adapter.Adapter_Sach;
import com.example.quanlysachphuongnam.Model.Sach;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class QuanLySachActivity extends AppCompatActivity {
    Button btnthem,btnsua,btnxoa,btnxemdanhsach,btnXoa,btnHuy;
    RecyclerView recyclerView;
    List<Sach>sachList;
    Adapter_Sach adapter_sach;
    TextInputEditText txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    EditText edt_xoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sach);
       anhxa();
       sachList = new ArrayList<>();
       //danh sách ảo
       adapter_sach = new Adapter_Sach(sachList,this,R.layout.recycle_sach);
       recyclerView.setAdapter(adapter_sach);
       btnthem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String masach = txt1.getText().toString().trim();
               String tensach = txt2.getText().toString().trim();
               String giaban = txt3.getText().toString().trim();
               String tacgia = txt4.getText().toString().trim();
               String nhaxuatban = txt5.getText().toString().trim();
               String theloai = txt6.getText().toString().trim();
               String soluong = txt7.getText().toString().trim();
               sachList.add(new Sach(masach,tensach,giaban,tacgia,nhaxuatban,theloai,soluong));
               adapter_sach.notifyDataSetChanged();
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
              DiaLogXoaSach();

           }
       });



    }
    private  void DiaLogXoaSach(){
        final  Dialog dialog = new Dialog(this);
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
    public  void xoasach(String id){
        for (int i=0;i<sachList.size();i++){
            if (id.equals(sachList.get(i).getMaSach())){
                sachList.remove(i);
            }
        }
        adapter_sach.notifyDataSetChanged();
    }


//    // option menu
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//       MenuInflater menuInflater = getMenuInflater();
//       menuInflater.inflate(R.menu.item_sach,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId()==R.id.them){
//            Toast.makeText(QuanLySachActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
//        }else  if (item.getItemId()==R.id.sua){
//            Toast.makeText(QuanLySachActivity.this,"Sửa thành công",Toast.LENGTH_LONG).show();
//
//        }else  if (item.getItemId()==R.id.xoa){
//            Toast.makeText(QuanLySachActivity.this,"Xóa thành công",Toast.LENGTH_LONG).show();
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
