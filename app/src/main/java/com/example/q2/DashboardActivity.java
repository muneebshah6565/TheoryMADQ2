package com.example.q2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {
    FirebaseAuth auth;

    Button newBill,viewAll,passChange,contactForm,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Dashboard");

        newBill=findViewById(R.id.newBill);
        viewAll=findViewById(R.id.viewAll);
        passChange=findViewById(R.id.passChange);
        contactForm=findViewById(R.id.contactForm);
        logout=findViewById(R.id.logout);
        auth=FirebaseAuth.getInstance();

        if(auth.getCurrentUser()==null){
            Intent intent = new Intent(DashboardActivity.this, Login.class);
            startActivity(intent);
            finish();
        }

        newBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DashboardActivity.this, AddBill.class);
                startActivity(intent);
            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DashboardActivity.this, ListOfBills.class);
                startActivity(intent);
            }
        });

        passChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DashboardActivity.this, PasswordReset.class);
                startActivity(intent);
            }
        });

        contactForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DashboardActivity.this, ContactForm.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent = new Intent( DashboardActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}