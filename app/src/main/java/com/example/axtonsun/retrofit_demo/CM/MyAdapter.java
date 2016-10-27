package com.example.axtonsun.retrofit_demo.CM;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.axtonsun.retrofit_demo.R;

import java.util.Collection;
import java.util.List;

/**
 * Created by AxtonSun on 2016/10/27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context context;
    private List<Cook> list;

    public MyAdapter(Context context, List<Cook> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cook_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Cook cook = list.get(position);
        holder.tv1.setText(cook.getName());
        holder.tv2.setText(cook.getDescription());
        Glide.with(context).load("http://tnfs.tngou.net/img"+cook.getImg()).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(Collection<? extends Cook> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView tv1,tv2;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_iv);
            tv1 = (TextView) itemView.findViewById(R.id.item_title);
            tv2 = (TextView) itemView.findViewById(R.id.item_info);
        }
    }
}
