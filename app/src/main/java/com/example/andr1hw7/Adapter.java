package com.example.andr1hw7;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import other.Other;

public class Adapter extends RecyclerView.Adapter<viewHolder> {
    private ArrayList<Other> others = new ArrayList<>();
    private OnItemClick onItemClick;
    public  Adapter(){}

    public void setColor(int color , int position){
        others.get(position).setColor(color);
        others.set(position,others.get(position));
        notifyDataSetChanged();
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder,parent,false);
        return new viewHolder(view);

    }
    public  void  setOthers(ArrayList<Other> others){
        this.others = others;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.onBind(others.get(position));
        holder.itemView.setOnClickListener(v -> onItemClick.onClick(others.get(position),position));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                dialog.setTitle("Удаление");
                dialog.setMessage("Вы точно хотите удалить?");
                dialog.setPositiveButton("Да", (dialog12, which) -> {
                    others.remove(position);
                    notifyDataSetChanged();
                })
                        .setNegativeButton("Нет", (dialog1, which) -> dialog1.cancel())
                        .show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return others.size();
    }
    public interface OnItemClick{
        void onClick(Other other, int position);
    }
}