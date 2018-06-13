package com.qicaiz.timerutility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UartPrincipleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uart_principle);
        TextView textView = (TextView) findViewById(R.id.tv_uart);
        try {
            InputStream is = getResources().getAssets().open("Uart.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String temp=null;
            StringBuilder sb =new StringBuilder();
            while((temp=br.readLine())!=null){
                sb.append(temp);
            }
            textView.setText(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
