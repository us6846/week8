package com.example.shiyan8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1=(TextView) findViewById(R.id.ac);
        Intent intent=getIntent();
        String account1=intent.getStringExtra("ac1");
        textView1.setText(account1);
    }
}