package com.study.ex16.ex16_mylist4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final MyAdapter adapter = new MyAdapter();

        SingerItem item1 = new SingerItem("홍길동", "20", R.mipmap.face1);
        adapter.addItem(item1);

        SingerItem item2 = new SingerItem("이순신", "25", R.mipmap.face2);
        adapter.addItem(item2);

        SingerItem item3 = new SingerItem("김유신", "30", R.mipmap.face3);
        adapter.addItem(item3);


        ListView listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);
                Toast.makeText(
                        getApplicationContext(),
                        "selected : " + item.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inputName = editText1.getText().toString();
                String inputAge = editText2.getText().toString();

                SingerItem item = new SingerItem(inputName, inputAge, R.mipmap.face1);
                adapter.addItem(item);
                // add하고나서 리스트뷰 갱신
                adapter.notifyDataSetChanged();
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<>();

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
            SingerItemView sView = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(i);

            sView.setName(item.getName());
            sView.setAge (item.getAge());
            sView.setImage(item.getResId());

            return sView;
        }
    }
}
