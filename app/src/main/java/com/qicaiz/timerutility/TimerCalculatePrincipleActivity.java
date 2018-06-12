package com.qicaiz.timerutility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TimerCalculatePrincipleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_calculate_principle);
        TextView textView = (TextView) findViewById(R.id.tv_timer_principle);
        try {
            InputStream is = getResources().getAssets().open("Timer.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String temp="";
            while((temp=br.readLine())!=null){
                sb.append(temp);
            }
            textView.setText(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
            textView.setText("他妈的，发生异常了");
        }
    }
}
