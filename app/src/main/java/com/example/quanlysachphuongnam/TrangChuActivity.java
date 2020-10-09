package com.example.quanlysachphuongnam;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlysachphuongnam.Model.HoaDon;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    ArrayList<ItemMenu> arrayList;
    MenuAdapter adapter;
    ImageView img_qltk,img_qlhd,img_gt,img_qls,img_Qltl,img_tk;
    Text txticon1,txticon2,txticon3,txticon4,txticon5;
    public static List<HoaDon> hoaDonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        anhxa();
        hoaDonList = new ArrayList<>();
        actionToolBar();
        actionMenu();
        img_qltk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(TrangChuActivity.this,QuanLyNguoiDungActivity.class);
                startActivity(a);
            }
        });
        img_qlhd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(TrangChuActivity.this,QuanLyHoaDonActivity.class);
                startActivity(b);
            }
        });
        img_gt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(TrangChuActivity.this,GioiThieuActivity.class);
                startActivity(c);
            }
        });
        img_qls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  d = new Intent(TrangChuActivity.this,QuanLySachActivity.class);
                startActivity(d);
            }
        });
        img_Qltl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(TrangChuActivity.this,QuanLyTheLoaiActivity.class);
                startActivity(e);
            }
        });
        img_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(TrangChuActivity.this,ThongkeActivity.class);
                startActivity(f);
            }
        });
    }



    // option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.thoat){
            onBackPressed();

        }
        else if(item.getItemId()==R.id.caidat1){
            Toast.makeText(TrangChuActivity.this,"Cài Đặt 1",Toast.LENGTH_LONG).show();
        }else  if (item.getItemId()==R.id.caidat2){
            //phan nay
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.lienhe);
            dialog.show();
        }
//        else if (item.getItemId()==R.id.txticon1){
//            final  Dialog dialog = new Dialog(this);
//            dialog.setContentView(R.layout.activity_quan_ly_sach);
//            dialog.setContentView(R.layout.activity_quan_ly_hoa_don);
//            dialog.setContentView(R.layout.activity_quan_ly_nguoi_dung);
//            dialog.setContentView(R.layout.activity_quan_ly_the_loai);
//            dialog.show();
//
//
//        }
        return super.onOptionsItemSelected(item);
    }

    private void actionMenu() {
        arrayList = new ArrayList<>();
        arrayList.add(new ItemMenu("Quản lý sách",R.drawable.ic_action_menu));
        arrayList.add(new ItemMenu("Quản lý thể loại",R.drawable.ic_action_menu));
        arrayList.add(new ItemMenu("Quản Lý Tài Khoản",R.drawable.ic_action_menu));
        arrayList.add(new ItemMenu("Quản Lý Hóa Đơn",R.drawable.ic_action_menu));
        arrayList.add(new ItemMenu("Giới Thiệu ",R.drawable.ic_action_menu));
        arrayList.add(new ItemMenu("Thống Kê",R.drawable.ic_action_menu));
        adapter = new MenuAdapter(this,R.layout.dong_item,arrayList);
        listView.setAdapter(adapter);

    }

    private void actionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



    private void anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_home);
        navigationView = (NavigationView) findViewById(R.id.navigationview_home);
        listView = (ListView) findViewById(R.id.ListView_home);

        img_qltk = (ImageView) findViewById(R.id.img_Qltk);
        img_qlhd = (ImageView) findViewById(R.id.img_Qlhd);
        img_gt = (ImageView) findViewById(R.id.img_GT);
        img_qls = (ImageView) findViewById(R.id.img_Qls);
        img_Qltl = (ImageView) findViewById(R.id.img_Qltl);
        img_tk = (ImageView) findViewById(R.id.img_Tk);

    }


}
