package com.example.tasticmoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orhanobut.dialogplus.OnBackPressListener;

public class click_mood extends AppCompatActivity implements View.OnClickListener{
    Button sad, angry, shy, okay, tired, calm, proud, worried, excited;
    SharedPreferences mood;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_mood);

        mood= getSharedPreferences("Score", Context.MODE_PRIVATE);


        sad= (Button) findViewById(R.id.sad_button);
        angry= (Button) findViewById(R.id.angry_button);
        shy= (Button) findViewById(R.id.shy_button);
        okay= (Button) findViewById(R.id.okay_button);
        tired= (Button) findViewById(R.id.tired_button);
        calm= (Button) findViewById(R.id.calm_button);
        proud= (Button) findViewById(R.id.proud_button);
        worried= (Button) findViewById(R.id.worried_button);
        excited= (Button) findViewById(R.id.excited_button);

        sad.setOnClickListener(this);
        angry.setOnClickListener(this);
        shy.setOnClickListener(this);
        okay.setOnClickListener(this);
        tired.setOnClickListener(this);
        calm.setOnClickListener(this);
        proud.setOnClickListener(this);
        worried.setOnClickListener(this);
        excited.setOnClickListener(this);

        /*sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sad ="SAD";
                SharedPreferences.Editor editor=mood.edit();
                editor.putString("sad",sad);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String angry ="ANGRY";
                SharedPreferences.Editor editor=mood.edit();
                editor.putString("angry",angry);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        shy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shy ="SHY";
                SharedPreferences.Editor editor=mood.edit();
                editor.putString("shy",shy);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String okay ="I FEEL OKAY";
                SharedPreferences.Editor editor=mood.edit();
                editor.putString("okay",okay);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        tired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        calm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        proud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        worried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });
        excited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), note.class);
                startActivity(intent);
            }
        });*/


    }


    @Override
    public void onClick(View view){

        SharedPreferences.Editor editor=mood.edit();

        switch (view.getId()) {
            case R.id.sad_button:
                String sad = "I FEEL SAD";
                editor.putString("MOOD", sad);
                editor.commit();
                Toast.makeText(this, "Sad", Toast.LENGTH_SHORT).show();
               IntentKungkuru();
                break;
            case R.id.angry_button:
                String angry = "I FEEL ANGRY";
                editor.putString("MOOD", angry);
                editor.commit();
                Toast.makeText(this, "Angry", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
            case R.id.shy_button:
                String shy = "I FEEL SHY";
                editor.putString("MOOD", shy);
                editor.commit();
                Toast.makeText(this, "Shy", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
            case R.id.okay_button:
                String okay = "I FEEL OKAY";
                editor.putString("MOOD", okay);
                editor.commit();
                Toast.makeText(this, "Okay", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
            case R.id.tired_button:
                String tired = "I FEEL TIRED";
                editor.putString("MOOD", tired);
                editor.commit();
                Toast.makeText(this, "Tired", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
            case R.id.calm_button:
                String calm = "I FEEL CALM";
                editor.putString("MOOD", calm);
                editor.commit();
                Toast.makeText(this, "Calm", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
            case R.id.proud_button:
                String proud = "I FEEL PROUD";
                editor.putString("MOOD", proud);
                editor.commit();
                Toast.makeText(this, "Proud", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
            case R.id.worried_button:
                String worried = "I FEEL WORRIED";
                editor.putString("MOOD", worried);
                editor.commit();
                Toast.makeText(this, "Worried", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
            case R.id.excited_button:
                String excited = "I FEEL EXCITED";
                editor.putString("MOOD", excited);
                editor.commit();
                Toast.makeText(this, "Excited", Toast.LENGTH_SHORT).show();
                IntentKungkuru();
                break;
        }
    }

    public void IntentKungkuru(){
        Intent intent = new Intent(click_mood.this, note.class);
        startActivity(intent);
    }


}