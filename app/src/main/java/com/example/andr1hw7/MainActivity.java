package com.example.andr1hw7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import other.Other;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClick {


    RecyclerView rv;
    Adapter  adapter;
    DialogFragment dialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRv();
        getOtherList();
    }

    private  void  setRv(){
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter();
        rv.setAdapter(adapter);
        adapter.setOthers(getOtherList());
        adapter.setOnItemClick(this);

    }

    private ArrayList<Other> getOtherList(){
        ArrayList<Other> others = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            others.add(new Other("lol",34,R.color.white));
        }
        return others;
    }

    @Override
    public void onClick(Other other, int position) {
        dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"lol");
        dialogFragment.setPosition(position);
    }
}