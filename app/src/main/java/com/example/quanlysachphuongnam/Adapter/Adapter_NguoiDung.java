package com.example.quanlysachphuongnam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Model.NguoiDung;
import com.example.quanlysachphuongnam.R;

import java.util.List;

public class Adapter_NguoiDung extends RecyclerView.Adapter<Adapter_NguoiDung.ViewHolder> {
    List<NguoiDung> nguoiDungList;
    Context context;
    int layout;
    public  static  boolean flag = false;
    @NonNull
    @Override
    public Adapter_NguoiDung.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_NguoiDung.ViewHolder holder, int position) {
        holder.username.setText(nguoiDungList.get(position).getUserName());
        holder.password.setText(nguoiDungList.get(position).getPassWord());
        holder.sodienthoai.setText(nguoiDungList.get(position).getSoDienThoai());
        holder.hoten.setText(nguoiDungList.get(position).getHoTen());

    }

    @Override
    public int getItemCount() {
        return nguoiDungList.size();
    }
    public  class  ViewHolder extends  RecyclerView.ViewHolder{
        TextView username,password,sodienthoai,hoten;
        Button btn_QLND;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.recycle_QLND_username);
            password = itemView.findViewById(R.id.recycle_QLND_password);
            sodienthoai = itemView.findViewById(R.id.recycle_QLND_sodienthoai);
            hoten = itemView.findViewById(R.id.recycle_QLND_hoten);
            btn_QLND = itemView.findViewById(R.id.btn_recycle_QLND);
        }
    }
}
