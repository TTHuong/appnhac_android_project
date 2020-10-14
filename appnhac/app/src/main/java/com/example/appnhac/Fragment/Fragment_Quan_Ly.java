package com.example.appnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnhac.Activity.ThemBaiHatActivity;
import com.example.appnhac.Activity.XoaBaiHatActivity;
import com.example.appnhac.R;

public class Fragment_Quan_Ly extends Fragment {
    View view;
    ImageView image_thembaihat,image_xoabaihat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_quan_ly,container,false);
        anhxa();
        return view;
    }

    private void anhxa() {
        image_thembaihat=view.findViewById(R.id.image_thembaihat);
        image_thembaihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemBaiHatActivity.class);
                startActivity(intent);
            }
        });
        image_xoabaihat=view.findViewById(R.id.image_xoabaihat);
        image_xoabaihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XoaBaiHatActivity.class);
                startActivity(intent);
            }
        });
    }

}
