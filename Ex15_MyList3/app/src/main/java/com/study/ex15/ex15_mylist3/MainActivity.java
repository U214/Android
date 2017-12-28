package com.study.ex15.ex15_mylist3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    String[] names = {"홍길동", "강감찬", "을지문덕", "양만춘", "유관순"};
    String[] ages = {"20", "25", "30", "35", "40"};
    int[] images = {R.mipmap.face1, R.mipmap.face2, R.mipmap.face3,
                    R.mipmap.face1, R.mipmap.face2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final MyAdapter adapter = new MyAdapter();
        ListView listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        getApplicationContext(),
                        "selected : " + names[i],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return names[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           SingerItemView sView = new SingerItemView(getApplicationContext());
           sView.setName(names[i]);
           sView.setAge (ages[i]);
           sView.setImage(images[i]);

           return sView;
        }
    }
}
