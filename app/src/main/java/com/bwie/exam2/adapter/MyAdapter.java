package com.bwie.exam2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bwie.exam2.R;

import java.util.List;

import com.bwie.exam2.bean.Bean;

/**
 * date:2018/11/12
 * author:mxy(M)
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int type = 0;
    private List<Bean.DataBean> list;
    private Context context;

    public MyAdapter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == 0) {
            View v = View.inflate(context, R.layout.one_layout, null);
            holder = new MyHoder1(v);
        }
        if (viewType == 1) {
            View v = View.inflate(context, R.layout.two_layout, null);
            holder = new MyHoder2(v);
        }
        if (viewType == 2) {
            View v = View.inflate(context, R.layout.three_layout, null);
            holder = new MyHoder3(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHoder1) {
            ((MyHoder1) holder).tx.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(((MyHoder1) holder).img);
        }
        if (holder instanceof MyHoder2) {
            ((MyHoder2) holder).tx.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(((MyHoder2) holder).img1);
            Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(((MyHoder2) holder).img2);
        }
        if (holder instanceof MyHoder3) {
            ((MyHoder3) holder).tx.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(((MyHoder3) holder).img1);
            Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(((MyHoder3) holder).img2);
            Glide.with(context).load(list.get(position).getThumbnail_pic_s03()).into(((MyHoder3) holder).img3);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getThumbnail_pic_s02() != null) {
            type = 1;
        }
        if (list.get(position).getThumbnail_pic_s03() != null) {
            type = 2;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHoder1 extends RecyclerView.ViewHolder {
        private TextView tx;
        private ImageView img;

        public MyHoder1(View itemView) {
            super(itemView);
            tx = itemView.findViewById(R.id.one_text);
            img = itemView.findViewById(R.id.one_img);
        }
    }

    class MyHoder2 extends RecyclerView.ViewHolder {
        private TextView tx;
        private ImageView img1, img2;

        public MyHoder2(View itemView) {
            super(itemView);
            tx = itemView.findViewById(R.id.two_text);
            img1 = itemView.findViewById(R.id.two_img1);
            img2 = itemView.findViewById(R.id.two_img2);
        }
    }

    class MyHoder3 extends RecyclerView.ViewHolder {
        private TextView tx;
        private ImageView img1, img2, img3;

        public MyHoder3(View itemView) {
            super(itemView);
            tx = itemView.findViewById(R.id.three_text);
            img1 = itemView.findViewById(R.id.three_img1);
            img2 = itemView.findViewById(R.id.three_img2);
            img3 = itemView.findViewById(R.id.three_img3);
        }
    }
}
