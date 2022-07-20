package com.example.tasticmoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class habit extends AppCompatActivity implements View.OnClickListener {
    Button walk, bubble, breathe, fruit, next, backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        walk = (Button) findViewById(R.id.walk_btn);
        bubble = (Button) findViewById(R.id.bubble_btn);
        breathe = (Button) findViewById(R.id.breathe_btn);
        fruit = (Button) findViewById(R.id.fruit_btn);
        next = (Button) findViewById(R.id.next_habit);
        backBtn = (Button) findViewById(R.id.next_habit2);

        walk.setOnClickListener(this);
        bubble.setOnClickListener(this);
        breathe.setOnClickListener(this);
        fruit.setOnClickListener(this);
        next.setOnClickListener(this);
        backBtn.setOnClickListener(this);


        /*walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), inside_walk.class);
                startActivity(intent);
            }
        });
        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), inside_bubble.class);
                startActivity(intent);
            }
        });
        breathe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), inside_breath.class);
                startActivity(intent);
            }
        });
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), inside_fruit.class);
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), habit2.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.walk_btn:
                Intent intent = new Intent(getApplicationContext(), inside_walk.class);
                startActivity(intent);
                break;
            case R.id.bubble_btn:
                Intent intent1 = new Intent(getApplicationContext(), inside_bubble.class);
                startActivity(intent1);
                break;
            case R.id.breathe_btn:
                Intent intent2 = new Intent(getApplicationContext(), inside_breath.class);
                startActivity(intent2);
                break;
            case R.id.fruit_btn:
                Intent intent3 = new Intent(getApplicationContext(), inside_fruit.class);
                startActivity(intent3);
                break;
            case R.id.next_habit:
                Intent intent4 = new Intent(getApplicationContext(), habit2.class);
                startActivity(intent4);
                break;
            case R.id.next_habit2:
                Intent intent5 = new Intent(getApplicationContext(), note.class);
                startActivity(intent5);


        }

    }
}

