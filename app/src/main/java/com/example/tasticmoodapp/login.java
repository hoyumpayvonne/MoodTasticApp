package com.example.tasticmoodapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    TextView signup;
    Button login;
    EditText user, pass;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = (TextView) findViewById(R.id.signup);
        signup = (TextView) findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        mUser = mAuth.getCurrentUser();
        login = (Button) findViewById(R.id.login);


        if(mUser != null){
            startActivity(new Intent(login.this, greetings.class));
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, register.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = user.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if(email.isEmpty()){
                    user.setError("Full Name is Required");
                    user.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    user.setError("Provide a Valid Email");
                    user.requestFocus();
                    return;
                }

                if(password.isEmpty()){
                    pass.setError("Provide a Valid Email");
                    pass.requestFocus();
                    return;
                }

                if(password.length()< 6){
                    pass.setError("Minimum of Six Characters");
                    pass.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            nextToGame();
                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(login.this, "Incorrect Password or Email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void nextToGame() {
        Intent intent = new Intent(login.this, greetings.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}