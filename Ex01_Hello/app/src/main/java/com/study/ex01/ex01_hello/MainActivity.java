package com.study.ex01.ex01_hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Log.d("study", "Hello~");

        // 버튼1 :
        // 클릭 이벤트 추가
        // 토스트 생성
        Button bnt1 = (Button)findViewById(R.id.button1);
        bnt1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "긴 토스트",
                        Toast.LENGTH_LONG).show();

                Log.d("study", "aaaa");
            }
        });

        // 버튼2 :
        // 인텐트(의도를 던지는 것) 만들어 웹브라우저 띄우기
        Button bnt2 = (Button)findViewById(R.id.button2);
        bnt2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        // 버튼3 :
        // 인텐트 만들어 전화 걸기
        Button bnt3 = (Button)findViewById(R.id.button3);
        bnt3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("tel:01074693800"));
                startActivity(intent);
            }
        });

        // 버튼4 :
        // EditText에 입력한 값을 TextView에 보여 주기
        Button bnt4 = (Button)findViewById(R.id.button4);
        bnt4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EditText editText1 = (EditText)findViewById(R.id.editText1);

                String str = editText1.getText().toString();

                TextView textView1 = (TextView)findViewById(R.id.textView1);
                textView1.setText(str);

               Toast.makeText(
                       getApplicationContext(),
                       "EditText : " + str,
                       Toast.LENGTH_SHORT).show();
            }
        });

        // 버튼5 :
        // 1. 내가 생성한 액티비티 실행
        // 2. 데이터 전달
        // 3. 결과 받아오기
        Button bnt5 = (Button)findViewById(R.id.button5);
        bnt5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        NewActivity.class);
                intent.putExtra("CustormerName", "홍길동");
                intent.putExtra("CustormerNumber", "007");
                startActivityForResult(intent, 1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String sData = "";
        String str = "OnActivityResult() called : " +
                requestCode + " : " +
                resultCode;

        if (requestCode == 1) {
            sData = data.getStringExtra("BackData");
            str = str + " : " + sData;
        }

        Toast.makeText(
                getApplicationContext(),
                str,
                Toast.LENGTH_SHORT).show();
    }
}
