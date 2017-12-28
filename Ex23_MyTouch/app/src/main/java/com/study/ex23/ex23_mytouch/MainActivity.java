package com.study.ex23.ex23_mytouch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // 터치된 손가락의 숫자
                int pointerCount = motionEvent.getPointerCount();

                float curX1 = 0.0f;
                float curY1 = 0.0f;
                float curX2 = 0.0f;
                float curY2 = 0.0f;

                if (pointerCount == 1) {
                    curX1 = motionEvent.getX(0);
                    curY1 = motionEvent.getY(0);
                } else if (pointerCount == 2) {
                    curX1 = motionEvent.getX(0);
                    curY1 = motionEvent.getY(0);
                    curX2 = motionEvent.getX(1);
                    curY2 = motionEvent.getY(1);
                }

                int action = motionEvent.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("study", "Touch down...." +
                            curX1 + " : " + curY1 + " / " +
                                curX2 + " : " + curY2);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        Log.d("study", "Touch move...." +
                                curX1 + " : " + curY1 + " / " +
                                curX2 + " : " + curY2);
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.d("study", "Touch up...." +
                                curX1 + " : " + curY1 + " / " +
                                curX2 + " : " + curY2);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });
    }
}
