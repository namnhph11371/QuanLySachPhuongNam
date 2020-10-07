package com.example.quanlysachphuongnam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.Model.TheLoai;
import com.example.quanlysachphuongnam.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class Adapter_TheLoai extends RecyclerView.Adapter <Adapter_TheLoai.ViewHolder> {
    List<TheLoai> theLoaiList;
    Context context;
    int layout;
    public static  int position = -1;

    public Adapter_TheLoai(List<TheLoai> theLoaiList, Context context, int layout) {
        this.theLoaiList = theLoaiList;
        this.context = context;
        this.layout = layout;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, parent, false);
        final Adapter_TheLoai.ViewHolder viewHolder = new ViewHolder(view);
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
        final  TheLoai theLoai = theLoaiList.get(position);
        holder.txtMaSach.setText("Mã Sách"+theLoai.getMaSach());
        holder.txtTenSach.setText("Tên Sách"+theLoai.getTenSach());
        holder.txtTheLoai.setText("Thể loại"+theLoai.getTheLoai());
        holder.txtTacGia.setText("Tác Giả"+theLoai.getTacGia());
        holder.txtNhaXuatBan.setText("Nhà xuất bản"+theLoai.getNhaXuatBan());
        holder.btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return theLoaiList.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder {
          TextView txtMaSach,txtTenSach,txtTheLoai,txtTacGia,txtNhaXuatBan;
           Button btnthem,btnsua,btnxoa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaSach = itemView.findViewById(R.id.recycle_TL_MaSach);
            txtTenSach =itemView.findViewById(R.id.recycle_TL_TenSach);
            txtTheLoai = itemView.findViewById(R.id.recycle_TL_TheLoai);
            txtTacGia = itemView.findViewById(R.id.recycle_TL_TacGia);
            txtNhaXuatBan = itemView.findViewById(R.id.recycle_TL_NhaXuatBan);
            btnthem= itemView.findViewById(R.id.button_QLTL_Them);
            btnsua = itemView.findViewById(R.id.button_QLTL_Sua);
            btnxoa = itemView.findViewById(R.id.button_QLTL_Xoa);
        }
    }


}
