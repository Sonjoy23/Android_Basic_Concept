package com.example.signinandsignupusingsqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class create_accout extends AppCompatActivity {

    Button submitButton;
    EditText createNameEdit, createGamilEdit,createUserEdit, createPasswordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_accout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myDatabaseHelper bd_helper=new myDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=bd_helper.getWritableDatabase();

        submitButton=findViewById(R.id.submit_id);
        createNameEdit=findViewById(R.id.name_id);
        createGamilEdit=findViewById(R.id.gmail_id);
        createUserEdit=findViewById(R.id.user_id);
        createPasswordEdit=findViewById(R.id.password_editText_id);







        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String nameData=createNameEdit.getText().toString();
                    String gmailData=createGamilEdit.getText().toString();
                    String userNameData=createUserEdit.getText().toString();
                    String passwordData=createPasswordEdit.getText().toString();
                    if(!nameData.trim().isEmpty() && !gmailData.trim().isEmpty() && !userNameData.trim().isEmpty() && !passwordData.trim().isEmpty()){
                        long insertMethodReturn = bd_helper.insertData(nameData,gmailData,userNameData,passwordData);
                        if(insertMethodReturn>0){
                            Toast.makeText(create_accout.this, "data inserted successfully ", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(create_accout.this, Home.class);
                            startActivity(intent);
                            createNameEdit.setText("");
                            createGamilEdit.setText("");
                            createUserEdit.setText("");
                            createPasswordEdit.setText("");
                        }else{
                            Toast.makeText(create_accout.this, "Data inserted not successfully", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(create_accout.this, "Please insert Right data", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Create_account :"+e,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}