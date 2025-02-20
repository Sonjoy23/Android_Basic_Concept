package com.example.signinandsignupusingsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    Button loginButton, createAccountButton,manageData;
    EditText name,password;

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
        createAccountButton=findViewById(R.id.create_button_id);
        manageData=findViewById(R.id.manageDataId);
        loginButton=findViewById(R.id.login_button_id);
        name=findViewById(R.id.user_name_editText_id);
        password=findViewById(R.id.password_editText_id);


        createAccountButton.setOnClickListener(this);
        manageData.setOnClickListener(this);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        myDatabaseHelper dbHelper=new myDatabaseHelper(this);

        // this is Create Account Button
        if(v.getId()==R.id.create_button_id){
            Intent intent =new Intent(MainActivity.this,create_accout.class);
            startActivity(intent);
        }

        // this is ShowData Button
        if(v.getId()==R.id.manageDataId){
            Intent intent=new Intent(MainActivity.this, com.example.signinandsignupusingsqlite.manageData.class);
            startActivity(intent);
        }
        // this is login button
        if(v.getId()==R.id.login_button_id){
            String StrName=name.getText().toString();
            String StrPassword=password.getText().toString();
            Cursor cursor=dbHelper.display();
            int count=cursor.getCount();

            if(count==0){
                Toast.makeText(getApplicationContext(),"please create account",Toast.LENGTH_SHORT).show();
                return;
            }

            while (cursor.moveToNext()){
                Toast.makeText(getApplicationContext(),"MoveToNext",Toast.LENGTH_SHORT).show();
                if(cursor.getString(0).equals(StrName) && cursor.getString(3).equals(StrPassword)){
                    Intent intent=new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Data is not found ",Toast.LENGTH_SHORT).show();
                }
            }


        }

    }
}