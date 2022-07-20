package com.example.tasticmoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.protobuf.JavaType;

public class note extends AppCompatActivity implements View.OnClickListener {

    Button save, edit, view, next;
    EditText typeBtn, name, age, date;
    TextView moods, reason;
    DatabaseReference MoodTasticUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        moods = (TextView) findViewById(R.id.mood1);
        reason = (TextView) findViewById(R.id.ent_reason);
        typeBtn = (EditText) findViewById(R.id.type);
        name = (EditText) findViewById(R.id.ent_name);
        age = (EditText) findViewById(R.id.ent_age);
        date = (EditText) findViewById(R.id.ent_date);
        save = (Button) findViewById(R.id.button_save);
        edit = (Button) findViewById(R.id.button_edit);
        view = (Button) findViewById(R.id.button_view);
        next = (Button) findViewById(R.id.button_next);
        MoodTasticUser = FirebaseDatabase.getInstance().getReference().child("users");

        next.setOnClickListener(this);
        save.setOnClickListener(this);
        view.setOnClickListener(this);
        edit.setOnClickListener(this);

        SharedPreferences mood = getApplicationContext().getSharedPreferences("Score", Context.MODE_PRIVATE);
        String score = mood.getString("MOOD", "");
        moods.setText(score);

        /*next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), habit.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = name.getText().toString();
                int age_num = Integer.parseInt(age.getText().toString());
                String emotion = moods.getText().toString();
                String type1 = typeBtn.getText().toString();
                String date1 = date.getText().toString();

                insert_data data1 = new insert_data(names, age_num, emotion, type1, date1);
                MoodTasticUser.push().setValue(data1);
                Toast.makeText(note.this, "Data has been saved!", Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listView.class);
                startActivity(intent);

            }
        });*/
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_save:
                String names = name.getText().toString();
                String age_num = age.getText().toString();
                String emotion = moods.getText().toString();
                String type1 = typeBtn.getText().toString();
                String date1 = date.getText().toString();
                insertData data1 = new insertData(names, age_num, emotion, type1, date1);
                MoodTasticUser.push().setValue(data1);
                Toast.makeText(note.this, "Data has been saved!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_edit:
                AlertDialog.Builder builder = new AlertDialog.Builder(edit.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("want to logout MOODTASTIC?");

                builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth.getInstance().signOut();
                        sigOutUser();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(edit.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                break;
            case R.id.button_view:
                Intent intent = new Intent(note.this, Userlist2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.button_next:
                Intent intent1 = new Intent(note.this, habit.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                break;
        }

    }

    private void sigOutUser() {
        Intent intent = new Intent(getApplicationContext(), login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}