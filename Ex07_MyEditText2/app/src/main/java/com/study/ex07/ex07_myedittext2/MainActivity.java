package com.study.ex07.ex07_myedittext2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    EditText inputMessage;
    String strAmount = ""; // 임시저장값(콤마)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        inputMessage = (EditText)findViewById(R.id.inputMessage);

        // 숫자만 입력
        // inputMessage.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputMessage.addTextChangedListener(watcher);
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            strAmount = charSequence.toString();
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d("study", charSequence.toString() + ":" + strAmount);
            if (!charSequence.toString().equals(strAmount)) { // 스택오버플로 방지
                strAmount = makeStringComma(charSequence.toString().replace(",", ""));
                inputMessage.setText(strAmount);
                inputMessage.setSelection(inputMessage.getText().length());
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    protected String makeStringComma(String str) {
        if(str.length() == 0) return  "";

        long value = Long.parseLong(str);
        DecimalFormat format = new DecimalFormat("###,##0");
        return format.format(value);
    }
}
