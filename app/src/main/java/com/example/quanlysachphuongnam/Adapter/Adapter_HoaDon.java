package com.example.quanlysachphuongnam.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Model.HoaDon;
import com.example.quanlysachphuongnam.R;
import com.example.quanlysachphuongnam.TrangChuActivity;

import java.util.List;

public class Adapter_HoaDon extends RecyclerView.Adapter<Adapter_HoaDon.ViewHolder> {
    List<HoaDon> hoaDonList;
    Context context;
    int layout;
    public  static int  position = -1;

    public Adapter_HoaDon(List<HoaDon> hoaDonList, Context context, int layout) {
        this.hoaDonList = hoaDonList;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout,parent,false);
        final  ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = viewHolder.getAdapterPosition();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
         final  HoaDon hoaDon = hoaDonList.get(position);
         holder.txtMaHoaDon.setText("Mã Hóa Đơn:"+ hoaDon.getMaHoaDon());
         holder.txtNgayMua.setText("Ngày Mua:"+hoaDon.getNgayMua());



    }

    @Override
    public int getItemCount() {
        return hoaDonList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView txtMaHoaDon,txtNgayMua;
        Button btn_recycle_hoadon,btnthem,btnsua,btnxoa;
        public ViewHolder(@NonNull View itemview){
            super(itemview);
            txtMaHoaDon = itemview.findViewById(R.id.recycle_HD_Mahoadon);
            txtNgayMua = itemview.findViewById(R.id.recycle_HD_NgayMua);
            btnthem =itemview.findViewById(R.id.button_QLHD_THEM);
            btnsua = itemview.findViewById(R.id.button_QLHD_SUA);
            btnxoa = itemview.findViewById(R.id.button_QLHD_XOA);

        }
    }
}
