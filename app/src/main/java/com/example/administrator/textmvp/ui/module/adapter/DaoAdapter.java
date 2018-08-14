package com.example.administrator.textmvp.ui.module.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.textmvp.R;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.example.administrator.textmvp.model.entity.HomeBeans;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class DaoAdapter extends BaseAdapter {
    private Context context;
    private List<DaoBeans> results;

    public DaoAdapter(Context context, List<DaoBeans> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_img, null);
        ImageView img = view.findViewById(R.id.img);
        Glide.with(context).load(results.get(position).getImgurl()).into(img);
        return view;
    }
}
