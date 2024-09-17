package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup group;
    private RadioButton male, female;
    private TextView view;


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

        group=(RadioGroup) findViewById(R.id.radioGroup);
        male=(RadioButton) findViewById(R.id.maleRadio);
        female =(RadioButton) findViewById(R.id.femaleRadio);
        view=(TextView) findViewById(R.id.textView);

        male.setOnClickListener((View.OnClickListener)this);
        female.setOnClickListener((View.OnClickListener)this);




    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.maleRadio){
            String str1=male.getText().toString();
            view.setText(str1);

        } else if (v.getId()==R.id.femaleRadio) {
            String str2=female.getText().toString();
            view.setText(str2);

        }

    }
}