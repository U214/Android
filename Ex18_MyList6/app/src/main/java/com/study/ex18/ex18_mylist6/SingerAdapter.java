package com.study.ex18.ex18_mylist6;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {

    Context context;
    ArrayList<SingerItem> items = new ArrayList<>();

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
        SingerItemView sView = null;

        if(view == null) {
            sView = new SingerItemView(context);
        } else {
            sView = (SingerItemView) view;
        }

        final SingerItem item = items.get(i);

        sView.setName(item.getName());
        sView.setTel (item.getTelnum());
        sView.setImage(item.getResId());

        // 리스트뷰안의 버튼 클릭 이벤트 처리
        Button button1 = (Button)sView.findViewById(R.id.button1);
        button1.setFocusable(false);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "tel: " + item.getTelnum();
                Log.d("study", str);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                context.startActivity(intent);
            }
        });

        return sView;
    }
}

