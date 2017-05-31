package com.guozhe.android.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1, button2;
    Intent intentSubIntent;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intentSubIntent =new Intent(this,SubActivity.class);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.editText2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }
    public static final int BUTTON_RESULT = 99;
    public static final int BUTTON_START = 98;

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button1:
                intentSubIntent.putExtra("key","");
                startActivityForResult(intentSubIntent,BUTTON_START);
                break;
            case R.id.button2:
                intentSubIntent.putExtra("key",editText.getText().toString());
                startActivityForResult(intentSubIntent,BUTTON_RESULT);
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case BUTTON_RESULT:
                   int result= data.getIntExtra("result",0);
                    Toast.makeText(this, "result 버튼을 눌렀다가 돌아옴", Toast.LENGTH_LONG).show();
                    editText.setText(""+result);
                    break;
                case BUTTON_START:
                    Toast.makeText(this, "start 버튼을 눌렀다가 돌아옴", Toast.LENGTH_LONG).show();
                    break;

            }
        }


    }
}
