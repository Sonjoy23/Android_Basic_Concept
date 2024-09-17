package com.example.toast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {
    private Button b1;
    private TextView v1;

    int n=0;

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
        b1=(Button)findViewById(R.id.LoginButton);
        v1=(TextView) findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v1.setText("clicked login button "+n+" time ");
                n++;
                // this is toast demo one
                /*if(v.getId()==R.id.LoginButton){
                    Toast.makeText(MainActivity.this,"login button is clicked ",Toast.LENGTH_SHORT).show();
                }*/
                // this is toast demo two
                if(v.getId()==R.id.LoginButton){
                    Toast toast=Toast.makeText(MainActivity.this,"login button is clicked, sonjoy",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            }
        });

    }

}