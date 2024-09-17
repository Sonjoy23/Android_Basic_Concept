package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox male, female;
    private TextView view1;

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
        male=(CheckBox) findViewById(R.id.checkbox1);
        female=(CheckBox) findViewById(R.id.checkbox2);
        view1=(TextView) findViewById(R.id.textview1);
        
        
        male.setOnClickListener((View.OnClickListener)this);
        female.setOnClickListener((View.OnClickListener)this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==(R.id.checkbox1)){
            view1.setText("you click male checkBox");

        }
        else if (v.getId()==(R.id.checkbox2)) {
            view1.setText("you click female checkBox");
        }


    }
}