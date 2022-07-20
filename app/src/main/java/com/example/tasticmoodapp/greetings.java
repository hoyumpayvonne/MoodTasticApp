package com.example.tasticmoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class greetings extends AppCompatActivity {
Button greetings_button;
TextView greet, qoutesOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        greetings_button= (Button) findViewById(R.id.button2);
        greet= (TextView) findViewById(R.id.greetings);
        qoutesOut = (TextView) findViewById(R.id.quotes);
        greetings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        calendarHours();
    }

    private void calendarHours() {
        Calendar hour = Calendar.getInstance();
         int von = hour.get(Calendar.HOUR_OF_DAY);

        if (von >= 1 && von < 11) {
            greet.setText("HELLO GOOD MORNING");
            qoutesOut.setText("Every morning is new arrival.");
        } else if (von >= 12 && von < 16) {
            greet.setText("HELLO GOOD AFTERNOON");
            qoutesOut.setText("Enjoy this noon as there as much more in life that awaits your presence.");
        } else if (von >= 16 && von < 21) {
            greet.setText("HELLO GOOD EVENING");
            qoutesOut.setText("Inhale and hold the evening in your lungs.");
        } else if (von >= 21 && von < 24) {
            greet.setText("HELLO GOOD NIGHT");
            qoutesOut.setText("Wishing you beautiful sweet dreams tonight GOODNIGHT!");
        } else {
            greet.setText("HELLO PIPS!");
        }
    }
}