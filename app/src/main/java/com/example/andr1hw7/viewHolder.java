package com.example.andr1hw7;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import other.Other;

public class viewHolder extends RecyclerView.ViewHolder {

    private TextView tv1,tv2;
    private CardView cardView;
    public viewHolder(@NonNull View itemView) {
        super(itemView);
        tv1 = itemView.findViewById(R.id.tv1);
        tv2 = itemView.findViewById(R.id.tv2);
        cardView = itemView.findViewById(R.id.cardVv);
    }

    public void onBind(Other other) {
        tv1.setText(other.getName());
        tv2.setText(String.valueOf(other.getAge()));
        cardView.setCardBackgroundColor(itemView.getResources().getColor(other.getColor()));
    }
}
