package com.bwie.exam2.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import com.bwie.exam2.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;



public class MyInfor extends Fragment{
    private ImageView img;
    private Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.myinfo_layout,container,false);
        img=view.findViewById(R.id.img);
        btn=view.findViewById(R.id.btn_t);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("name");
        Bitmap image = CodeUtils.createImage(name, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        img.setImageBitmap(image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }
}

