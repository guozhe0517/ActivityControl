package com.guozhe.android.activitycontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    String value="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);


        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            value = bundle.getString("key");
            textView.setText(value);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num1 = Integer.parseInt(value);
                    String  temp = editText.getText().toString();
                    int num2 = Integer.parseInt(temp);
                    int result = num1+num2;


                    Intent intent = new Intent();
                    intent.putExtra("result",result);

                    setResult(RESULT_OK,intent);
                    finish();

                }
            });

        }





    }
}
