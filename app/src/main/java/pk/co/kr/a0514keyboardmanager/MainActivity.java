package pk.co.kr.a0514keyboardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    Button btnshow;
    Button btnhide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.edit);
        btnshow = (Button)findViewById(R.id.btnshow);
        btnhide = (Button)findViewById(R.id.btnhide);

        //키보드 제어 객체 만들기
        final InputMethodManager manager =
                (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);


        //버튼들의 클릭 이벤트를 처리하개ㅣ 위한 객체 생성
        Button.OnClickListener eventHandler = new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v == btnshow){
                    //키보드 화면에 출력
                    manager.showSoftInput(edit,0);

                }
                else{
                    //키보드를 화면에서 숨김
                    manager.hideSoftInputFromWindow(edit.getWindowToken(),0);

                }
            }
        };
        btnshow.setOnClickListener(eventHandler);
        btnhide.setOnClickListener(eventHandler);

        LinearLayout layout = (LinearLayout)findViewById(R.id.main);
        layout.setOnTouchListener(new LinearLayout.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                manager.hideSoftInputFromWindow(edit.getWindowToken(),0);
                return false;
            }
        });
    }
}