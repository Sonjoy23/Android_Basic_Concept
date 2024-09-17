package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    private AlertDialog.Builder alertDilogBuilder;

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

        button=findViewById(R.id.buttonId);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        alertDilogBuilder=new AlertDialog.Builder(MainActivity.this);
        //this is title
        alertDilogBuilder.setTitle(R.string.title);
        //this is message
        alertDilogBuilder.setMessage(R.string.message);
        //this is icon
        alertDilogBuilder.setIcon(R.drawable.question_mark_circle);
        // alertDialog er bahire kothao cleck korle alertDialog cole jabe na
        alertDilogBuilder.setCancelable(false);
        //this is positive Button
        alertDilogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        //this is no button

        alertDilogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        //this is cancel button
        alertDilogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"you have click on cancal button",Toast.LENGTH_SHORT).show();

            }
        });


        AlertDialog alertDialog=alertDilogBuilder.create();
        alertDialog.show();

    }
}