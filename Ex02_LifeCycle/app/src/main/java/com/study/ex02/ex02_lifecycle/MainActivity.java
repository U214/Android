package com.study.ex02.ex02_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("study", "Main onClick");

                Intent intent = new Intent(
                        getApplicationContext(),
                        NewActivity.class);

                startActivityForResult(intent, 1);
            }
        });
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(
                getApplicationContext(),
                "onActivityResult() 호출됨",
                Toast.LENGTH_SHORT).show();
        Log.d("study", "onActivityResult() 호출됨");
    }
}
