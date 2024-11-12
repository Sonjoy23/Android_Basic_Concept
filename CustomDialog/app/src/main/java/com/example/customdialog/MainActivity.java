package com.example.customdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button clickButton;

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
        clickButton=findViewById(R.id.clickHereId);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"thank you",Toast.LENGTH_SHORT).show();
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setCancelable(false);
                // eita custom dialog ke boro frame er modhe adjust kore
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                // ekhane (dialog.findViewById(R.id.doneId)) kore dialog box e thaka done id ta khuje berkora hoyeche
                Button done=dialog.findViewById(R.id.doneId);
                 done.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(MainActivity.this,"custom dialog is done!  ",Toast.LENGTH_SHORT).show();
                         //toast ta dekhanor pore jeno dialog box ta dismiss hoye jabe
                         dialog.dismiss();
                     }
                 });
                 // dialog box ta show koranor jonno eita bola hoyeche
                 dialog.show();



            }
        });

    }
}
