package com.bwie.exam2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.exam2.R;
import com.google.gson.Gson;


import java.io.IOException;

import java.util.List;

import com.bwie.exam2.adapter.MyAdapter;
import com.bwie.exam2.bean.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import com.bwie.exam2.utils.OkHttpUtils;



public class MyList extends Fragment{
    private String str="http://www.xieast.com/api/news/news.php";
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.mylist_layout,container,false);
       recyclerView=view.findViewById(R.id.rec);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
    }

    public void getData() {
      
        OkHttpUtils.getInstence().get(str, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                final List<Bean.DataBean> data = bean.getData();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MyAdapter adapter=new MyAdapter(data,getActivity());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}






