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
        holder.txtMaTheLoai.setText("Mã Thể Loại:"+sach.getMaTheLoai());
        holder.txtTenSach.setText("Tên Sách:"+sach.getTenSach());
        holder.txtTacGia.setText("Tác Giả:"+sach.getTacGia());
        holder.txtNhaXuatBan.setText("Nhà xuất bản:"+sach.getNhaXuatban());
        holder.txtGiaBan.setText("Giá bán:"+sach.getGiaBan());
        holder.txtSoLuong.setText("Số Lượng:"+sach.getSoLuong());

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

            txtTacGia = itemView.findViewById(R.id.recycle_Sach_TacGia);
            txtNhaXuatBan = itemView.findViewById(R.id.recycle_Sach_NhaXuatBan);
            txtGiaBan = itemView.findViewById(R.id.recycle_Sach_GiaBan);
            txtSoLuong = itemView.findViewById(R.id.recycle_Sach_SoLuong);

        }
    }
}
