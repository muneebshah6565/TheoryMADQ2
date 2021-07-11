package com.example.q2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("View Bill Record");
        TextView textView1, textView2,textView3,textView4,textView5,textView6;

        Intent intent=getIntent();

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);

        textView1.setText(intent.getStringExtra("cName"));
        textView2.setText(intent.getStringExtra("cBillNo"));
        textView3.setText(intent.getStringExtra("meterNo"));
        textView4.setText(intent.getStringExtra("amount"));
        textView5.setText(intent.getStringExtra("lastUnits"));
        textView6.setText(intent.getStringExtra("currentUnits"));
    }
}