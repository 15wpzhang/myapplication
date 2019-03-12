package com.example.lem.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProAdapter extends RecyclerView.Adapter<ProAdapter.ViewHolder> {
    private List<Pro> mProList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView proImage;
        TextView proName;

        public ViewHolder(View view){
            super(view);
            proImage = (ImageView)view.findViewById(R.id.pro_image);
            proName = (TextView)view.findViewById(R.id.pro_name);
        }
    }
    public ProAdapter(List<Pro> proList){
        mProList = proList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pro_item,parent,false);
        ViewHolder holder = new ViewHolder (view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Pro pro=mProList.get(position);
        holder.proImage.setImageResource(pro.getImageId());
        holder.proName.setText(pro.getName());
    }
    @Override
    public int getItemCount(){
        return mProList.size();
    }
}
