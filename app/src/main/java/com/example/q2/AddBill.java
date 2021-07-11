package com.example.q2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Bill");
        EditText custName,billNo,meterNo,amount,lastUnits,currentUnits;
        Button save;


        custName= (EditText) findViewById(R.id.custName);
        billNo= (EditText) findViewById(R.id.billNo);
        meterNo= (EditText) findViewById(R.id.meterNo);
        amount=(EditText) findViewById(R.id.amount);
        lastUnits= (EditText) findViewById(R.id.lastUnits);
        currentUnits= (EditText) findViewById(R.id.currentUnits);
        save=(Button) findViewById(R.id.saveBTN);


      save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          String cname,cBillNo,cMeterNo,mAmount,cLastUnits,cUnits;
          cname=custName.getText().toString();
          cBillNo=billNo.getText().toString();
          cMeterNo=meterNo.getText().toString();
          mAmount=amount.getText().toString();
          cLastUnits=lastUnits.getText().toString();
          cUnits=currentUnits.getText().toString();
          DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Bills");
          String userId = mDatabase.push().getKey();
          BillModel bill = new BillModel(cname,cBillNo,cMeterNo,mAmount,cLastUnits,cUnits);
          mDatabase.child(userId).setValue(bill);
          Toast.makeText(getApplicationContext(),"Record Added Successfully",Toast.LENGTH_LONG).show();
    }
});
    }
    }
