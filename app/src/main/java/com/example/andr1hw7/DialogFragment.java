package com.example.andr1hw7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.andr1hw7.databinding.FragmentDialogBinding;


public class DialogFragment extends androidx.fragment.app.DialogFragment {
    private FragmentDialogBinding binding;
    private int color;
    private int position;
    MainActivity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentDialogBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        activity = (MainActivity) requireActivity();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        binding.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        color = R.color.red;
                        break;
                    case R.id.rb2:
                        color = R.color.green;
                        break;
                    case R.id.rb3:
                        color = R.color.orange;
                        break;
                    case R.id.rb4:
                        color = R.color.teal_700;
                        break;
                }
            }
        });
        binding.btnRadio.setOnClickListener(this::click);
    }

    private void click(View view ){
        if(color != 0 ){
            activity.adapter.setColor(color,position);
            getDialog().dismiss();
        }
    }
    public void setPosition(int position) {
        this.position = position;
    }
}