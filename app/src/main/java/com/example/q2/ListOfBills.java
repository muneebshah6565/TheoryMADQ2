package com.example.q2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListOfBills extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private static ArrayList<BillModel> data;
    private static RecyclerView.Adapter adapter;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_bills);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List of Bills");
        TextView textView1, textView2,textView3,textView4,textView5,textView6;
        recyclerView = findViewById(R.id.list);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("Bills");

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        data = new ArrayList<>();

        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        String name=postSnapshot.child("customerName").getValue().toString();
                        String billNo=postSnapshot.child("billNo").getValue().toString();
                        String meterNo=postSnapshot.child("cMeterNo").getValue().toString();
                        String amount=postSnapshot.child("mAmount").getValue().toString();
                        String lastUnits=postSnapshot.child("cLastUnits").getValue().toString();
                        String currentUnits=postSnapshot.child("cUnits").getValue().toString();
                        data.add(new BillModel(name,billNo,meterNo,amount,lastUnits,currentUnits));
                    }
                    adapter = new BillAdapter(getApplicationContext(),ListOfBills.this,data);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}