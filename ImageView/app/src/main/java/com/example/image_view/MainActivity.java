package com.example.image_view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView view1, view2;

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
        view1=(ImageView) findViewById(R.id.imageview1);
        view2=(ImageView) findViewById(R.id.imageView2);

        view1.setOnClickListener(this);
        view2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imageview1){
            Toast.makeText(MainActivity.this,"single Image",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.imageView2){
            Toast.makeText(MainActivity.this,"double Photo",Toast.LENGTH_SHORT).show();
        }

    }
}