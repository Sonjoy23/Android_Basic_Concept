package com.example.signinandsignupusingsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class manageData extends AppCompatActivity implements View.OnClickListener {

    private final String key = "404";

    Button display,delete;
    EditText key_pass, user_name;
    myDatabaseHelper mdHelper;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manage_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        display=findViewById(R.id.displayButtonId);
        delete=findViewById(R.id.DeleteButtonId);
        key_pass=findViewById(R.id.displayEditId);
        user_name=findViewById(R.id.DeleteEditId);
        textView=findViewById(R.id.displayTextId);

        display.setOnClickListener(this);
        delete.setOnClickListener(this);

        mdHelper=new myDatabaseHelper(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.displayButtonId){
            Toast.makeText(this,"click display button",Toast.LENGTH_SHORT).show();
            String my_key =key_pass.getText().toString();
            if(my_key.trim().equals(key)){
                Cursor cursor=mdHelper.display();
                if(cursor.getCount()==0){
                    Toast.makeText(this, "data is not found ", Toast.LENGTH_SHORT).show();
                    return;

                }

                 StringBuffer stringBuffer=new StringBuffer();

                while (cursor.moveToNext()){
                    stringBuffer.append("User_Name: "+cursor.getString(0)+"\n");
                    stringBuffer.append("Name: "+cursor.getString(1)+"\n");
                    stringBuffer.append("Gmail: "+cursor.getString(2)+"\n");
                    stringBuffer.append("Password: "+cursor.getString(3)+"\n\n\n");
                }
                textView.setText(stringBuffer);


            }
        }

        if(v.getId()==R.id.DeleteButtonId){
            String userName=user_name.getText().toString();
            int value=mdHelper.Delete(userName);
            if(value>0){
                Toast.makeText(getApplicationContext(),"data is deleted",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"data is not deleted",Toast.LENGTH_SHORT).show();
            }

        }

    }
}