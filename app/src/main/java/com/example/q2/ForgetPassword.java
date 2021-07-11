package com.example.q2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    FirebaseAuth auth;
    Button passReset;
    EditText emailField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Forgot Password");
        passReset=findViewById(R.id.button_forgot);
        emailField=findViewById(R.id.editTextEmail);

        auth=FirebaseAuth.getInstance();


        passReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailField.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    emailField.setError("Email is Required");
                    return;
                }
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),"Password Reset Send to Given Email",Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }
}