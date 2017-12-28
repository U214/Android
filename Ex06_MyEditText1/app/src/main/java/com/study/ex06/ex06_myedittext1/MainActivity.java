package com.study.ex06.ex06_myedittext1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class MainActivity extends Activity {
    TextView textView1;

    EditText etId;
    EditText etPwd;
    EditText etYear;
    EditText etMonth;
    EditText etDay;

    String sId;
    String sPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        textView1 = (TextView)findViewById(R.id.textView1);

        etId = (EditText)findViewById(R.id.etId);
        etPwd = (EditText)findViewById(R.id.etPwd);
        etYear = (EditText)findViewById(R.id.etYear);
        etMonth = (EditText)findViewById(R.id.etMonth);
        etDay = (EditText)findViewById(R.id.etDay);

        // 패스워드 입력시 글자수 체크
        etPwd.addTextChangedListener(watcher);

        // 키보드 내리기 버튼
        // inputType과 maxLength가 EditText에 지정되어있으면
        // 키보드에 리턴이 다음으로 됨
        // 입력칸이 키보드에 가려지면 자동으로 올라감
        Button btnKeyDown = (Button)findViewById(R.id.btnKeyDown);
        btnKeyDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // IME Hide
                InputMethodManager mgr =
                        (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

        });

        // 로그인 버튼
       Button btnLogin = (Button)findViewById(R.id.btnLogin);
       btnLogin.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               sId = etId.getText().toString();
               sPwd = etPwd.getText().toString();

               if (sId.length() < 3) {
                   new AlertDialog.Builder(MainActivity.this)
                           .setTitle("알림")
                           .setMessage("아이디를 입력해 주세요")
                           .setCancelable(false)
                           .setIcon(android.R.drawable.ic_dialog_alert)
                           .setPositiveButton("닫기", null)
                           .show();
                   etId.requestFocus();
                   return;
               } else if (sPwd.length() < 5) {
                   new AlertDialog.Builder(MainActivity.this)
                           .setTitle("알림")
                           .setMessage("비밀번호를 정확히 입력해 주세요")
                           .setCancelable(false)
                           .setIcon(android.R.drawable.ic_dialog_alert)
                           .setPositiveButton("닫기", null)
                           .show();
                   etPwd.requestFocus();
                   return;
               }
           }
       });
    }

    TextWatcher  watcher = new TextWatcher() {
           String beforeText;

           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               byte[] bytes = null;

               try{
                   bytes = charSequence.toString().getBytes("KSC5601");
                   int strCount = bytes.length;
                   textView1.setText(strCount + " / 8 바이트");
               } catch (UnsupportedEncodingException ex) {
                   ex.printStackTrace();
               }
           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               beforeText = charSequence.toString();
               Log.d("study", charSequence.toString());
           }

           @Override
           public void afterTextChanged(Editable editable) {
               String str = editable.toString();
               Log.d("study", str);

               try {
                   byte[] strBytes = str.getBytes("KSC5601");
                   if (strBytes.length > 8) {
                       etPwd.setText(beforeText);
                       etPwd.setSelection(beforeText.length()-1, beforeText.length()-1);
//                            editable.delete(editable.length()-2, editable.length()-1);
                   }
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
     };
}




















