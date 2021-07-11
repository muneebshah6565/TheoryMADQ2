package com.example.q2;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    Button signup;
    TextView alreadyAccount;
    EditText emailField,passwordField,cnfrmPassField;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Sign Up");

        signup=(Button) findViewById(R.id.button);
        alreadyAccount=(TextView) findViewById(R.id.alreadyAccount);

        emailField=(EditText) findViewById(R.id.editTextEmail);
        passwordField=(EditText) findViewById(R.id.editTextPassword);
        cnfrmPassField=(EditText) findViewById(R.id.editTextCPassword);

        auth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email=emailField.getText().toString().trim();
                String password=passwordField.getText().toString().trim();
                String cPass=cnfrmPassField.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailField.setError("Email is Required");
                    return;
                } else if(TextUtils.isEmpty(password)){
                    passwordField.setError("Password is Required");
                    return;
                }else if(TextUtils.isEmpty(cPass)){
                    cnfrmPassField.setError("Confirm Password is Required");
                    return;
                }else if(!password.equals(cPass)){
                    cnfrmPassField.setError("Confirm Password is not same to above");
                    return;
                }else if(password.length()<0){
                    passwordField.setError("Password must be >=6 characters");
                    return;
                }

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(getApplicationContext(),"User is Successfully Registered",Toast.LENGTH_LONG).show();
                         Intent intent = new Intent(SignUp.this, Login.class);
                         startActivity(intent);
                     }
                     else{
                         Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                     }
                    }
                });
            }
        });

        alreadyAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

    }
}