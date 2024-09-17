package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private TimePicker timePicker;

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

        textView=findViewById(R.id.textViewId);
        button=findViewById(R.id.buttonId);
        timePicker=findViewById(R.id.timePickerId);
        timePicker.setIs24HourView(false);

        textView.setText(timePicker.getHour()+":"+timePicker.getMinute());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time=timePicker.getHour()+":"+timePicker.getMinute();
                textView.setText(time);
            }
        });

    }
}