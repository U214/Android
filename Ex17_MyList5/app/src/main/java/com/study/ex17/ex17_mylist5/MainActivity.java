package com.study.ex17.ex17_mylist5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

// 껍데기를 재탕하기 위해 싱글턴 사용
// (메모리 절약)
public class MainActivity extends Activity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final SingerAdapter adapter = new SingerAdapter(this);

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
}
