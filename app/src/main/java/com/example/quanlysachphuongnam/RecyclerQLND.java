package com.example.quanlysachphuongnam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Model.NguoiDung;

import java.util.List;

public class RecyclerQLND extends RecyclerView.Adapter<RecyclerQLND.ViewHolder> {
    List<NguoiDung> nguoiDungList;
    Context context;
    int layout;


    public RecyclerQLND(List<NguoiDung> nguoiDungList, Context context, int layout) {
        this.nguoiDungList = nguoiDungList;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTen.setText(nguoiDungList.get(position).getHoTen());
        holder.txtSDT.setText(nguoiDungList.get(position).getSoDienThoai());
        holder.img_anhnen.setImageBitmap(nguoiDungList.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return nguoiDungList.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView img_anhnen,imgbutchi,imgClone;
        TextView txtSDT;
        TextView txtTen;
        public  ViewHolder(@NonNull View itemView){
            super(itemView);
            img_anhnen = itemView.findViewById(R.id.img_anhnen);
            imgbutchi = itemView.findViewById(R.id.img_butchi);
            imgClone = itemView.findViewById(R.id.img_delete);
            txtTen = itemView.findViewById(R.id.txtTen_recycleview);


        }

    }
}
