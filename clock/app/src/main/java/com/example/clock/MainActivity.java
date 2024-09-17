package com.example.clock;

import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.TextClock;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AnalogClock analogClock;
    private DigitalClock digitalClock;
    private TextClock textClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        analogClock=findViewById(R.id.analogClockId);
        digitalClock=(DigitalClock) findViewById(R.id.digitalClockId);
        textClock=(TextClock) findViewById(R.id.textClockId);

        analogClock.setOnClickListener(this);
        digitalClock.setOnClickListener(this);
        textClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.analogClockId){
            Toast.makeText(MainActivity.this,"analog clock",Toast.LENGTH_SHORT).show();
        } else if (v.getId()==R.id.digitalClockId) {
            Toast.makeText(MainActivity.this,"Digital Clock",Toast.LENGTH_SHORT).show();

        } else if (v.getId()==R.id.textClockId) {
            Toast.makeText(MainActivity.this,"TextClock ",Toast.LENGTH_SHORT).show();

        }
    }
}