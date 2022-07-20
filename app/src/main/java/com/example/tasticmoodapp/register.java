package com.example.tasticmoodapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {
    EditText user, pass;
    Button register;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = (EditText) findViewById(R.id.userid);
        pass = (EditText) findViewById(R.id.pass_id);
        register = (Button) findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        backBtn = (ImageView) findViewById(R.id.backArrow);

        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrationFormMood();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToActivity();
            }
        });

    }

    private void backToActivity() {
        Intent intent = new Intent(register.this, login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void registrationFormMood() {
        String email = user.getText().toString();
        String password = pass.getText().toString();

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

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            nextActivity();
                            Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(register.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void nextActivity() {
        Intent intent = new Intent(register.this, greetings.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}