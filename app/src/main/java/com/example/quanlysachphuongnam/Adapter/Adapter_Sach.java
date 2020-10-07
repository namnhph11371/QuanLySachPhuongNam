package com.example.quanlysachphuongnam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Model.Sach;
import com.example.quanlysachphuongnam.R;

import java.util.List;

public class Adapter_Sach extends  RecyclerView.Adapter <Adapter_Sach.ViewHolder> {
    List<Sach> sachList;
    Context context;
    int layout;
    public static int position = -1;

    public Adapter_Sach(List<Sach> sachList, Context context, int layout) {
        this.sachList = sachList;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = viewHolder.getAdapterPosition();
            }
        });
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  Sach sach = sachList.get(position);
        holder.txtMaSach.setText("Mã Sách:"+sach.getMaSach());
        holder.txtMaTheLoai.setText("Mã Sách:"+sach.getMaTheLoai());
        holder.txtTenSach.setText("Mã Sách:"+sach.getTenSach());
        holder.txtGiaNhap.setText("Mã Sách:"+sach.getGiaNhap());
        holder.txtTieuDe.setText("Mã Sách:"+sach.getTieuDe());
        holder.txtTacGia.setText("Mã Sách:"+sach.getTacGia());
        holder.txtNhaXuatBan.setText("Mã Sách:"+sach.getNhaXuatban());
        holder.txtGiaBan.setText("Mã Sách:"+sach.getGiaBan());
        holder.txtSoLuong.setText("Mã Sách:"+sach.getSoLuong());
//        holder.btn_sach.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtMaSach,txtMaTheLoai,txtTenSach,txtGiaNhap,txtTieuDe,txtTacGia,txtNhaXuatBan,txtGiaBan,txtSoLuong;
        Button btn_sach;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaSach = itemView.findViewById(R.id.recycle_Sach_MaSach);
            txtMaTheLoai = itemView.findViewById(R.id.recycle_Sach_MaTheLoai);
            txtTenSach = itemView.findViewById(R.id.recycle_Sach_TenSach);
            txtGiaNhap = itemView.findViewById(R.id.recycle_Sach_GiaNhap);
            txtTieuDe = itemView.findViewById(R.id.recycle_Sach_TieuDe);
            txtTacGia = itemView.findViewById(R.id.recycle_Sach_TacGia);
            txtNhaXuatBan = itemView.findViewById(R.id.recycle_Sach_NhaXuatBan);
            txtGiaBan = itemView.findViewById(R.id.recycle_Sach_GiaBan);
            txtSoLuong = itemView.findViewById(R.id.recycle_Sach_SoLuong);
            btn_sach = itemView.findViewById(R.id.btn_recycle_sach);
        }
    }
}
