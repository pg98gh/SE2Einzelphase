package com.example.currencychange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ServerSocket;


public class MainActivity extends AppCompatActivity {

    private Button sendtoserver;
    private Networking net;
    private EditText editText;
    private Button calc;
    private TextView server;
    private EditText result;

    //mtr ==01613210 %7=0
    public void calculate(View view){
        calc=findViewById(R.id.calclulate);
        editText= findViewById(R.id.mtrnr);
        String number=editText.getText().toString();
        int sum=0;
        for ( int i = 0 ; i < number.length( ) ; i++ ) {
            sum += Integer.parseInt(number.substring(i, i + 1));
        }
        number=Integer.toString(sum);
        result = findViewById(R.id.result);
        result.setText(number);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.mtrnr);
        sendtoserver=findViewById(R.id.server_btn);
        sendtoserver.setOnClickListener(
                a ->{

                    net = new Networking(editText.getText().toString());
                    net.start();
                    try{
                        net.join();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    Log.i("info", String.valueOf(editText));
                    server = findViewById(R.id.server);
                    server.setText(net.getResult());

                }
        );



    }



}