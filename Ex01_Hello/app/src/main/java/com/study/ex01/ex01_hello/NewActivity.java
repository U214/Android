package com.study.ex01.ex01_hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        Log.d("study", "NewActivity~");
        Intent intent = getIntent();

        final String sName = intent.getStringExtra("CustormerName");
        final String sNumber = intent.getStringExtra("CustormerNumber");

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "CustormorName : " + sName + "\nCustormerNumber : " + sNumber,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 인텐트 종료하기
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("BackData", "강감찬");
                setResult(10, intent);

                finish(); // 자살
            }
        });
    }
}
