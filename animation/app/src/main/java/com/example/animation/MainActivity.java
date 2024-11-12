package com.example.animation;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn1,btn2,btn3,btn4;

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
        textView=findViewById(R.id.textView);

        btn1=findViewById(R.id.scale);
        btn2=findViewById(R.id.rotate);
        btn3=findViewById(R.id.translator);
        btn4=findViewById(R.id.alpha);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation move=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                textView.startAnimation(move);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation alpha=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                textView.startAnimation(alpha);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scale=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                textView.startAnimation(scale);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                textView.startAnimation(rotate);
            }
        });

    }

}