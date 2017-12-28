package com.study.ex17.ex17_mylist5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {

    Context context;
    ArrayList<SingerItem> items = new ArrayList<SingerItem>();

    public SingerAdapter(Context context) {
        this.context = context;
    }

    public void addItem(SingerItem item) {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        SingerItemView sView = new SingerItemView(getApplicationContext());

        SingerItemView sView = null;

        if(view == null) {
            sView = new SingerItemView(context);
        } else {
            sView = (SingerItemView) view;
        }

        SingerItem item = items.get(i);

        sView.setName(item.getName());
        sView.setAge (item.getAge());
        sView.setImage(item.getResId());

        return sView;
    }
}

