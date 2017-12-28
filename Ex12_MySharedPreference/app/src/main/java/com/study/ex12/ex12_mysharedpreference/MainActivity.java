package com.study.ex12.ex12_mysharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        SharedPreferences pref = getSharedPreferences("login", Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        final EditText tvId = (EditText)findViewById(R.id.etID);
        final EditText tvPwd = (EditText)findViewById(R.id.etPwd);

        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sid = tvId.getText().toString();
                String spwd = tvPwd.getText().toString();

                editor.putString("id", sid);
                editor.putString("pwd", spwd);
                editor.commit();
            }
        });

        String id = pref.getString("id", "");
        String pwd = pref.getString("pwd", "");

        Log.d("study", "id : " + id);

        tvId.setText(id);
        tvId.setSelection(tvId.length());
        tvPwd.setText(pwd);
    }
}
