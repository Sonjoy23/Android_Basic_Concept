package com.example.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDatabaseHelper myDatabaseHelper;
    EditText nameEditText, ageEditText, genderEditText,idEditText;
    Button insertButton, showDataButton,updateButton,deleteButton;

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

        myDatabaseHelper=new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=myDatabaseHelper.getWritableDatabase();


        nameEditText=findViewById(R.id.name_id);
        ageEditText=findViewById(R.id.age_id);
        genderEditText=findViewById(R.id.gender_id);
        idEditText=findViewById(R.id.ID_id);
        insertButton=findViewById(R.id.button_id);
        showDataButton=findViewById(R.id.show_data_id);
        updateButton=findViewById(R.id.update_data_id);
        deleteButton=findViewById(R.id.delete_data_id);

        insertButton.setOnClickListener(this);
        showDataButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String id=idEditText.getText().toString();
        String name=nameEditText.getText().toString();
        String age=ageEditText.getText().toString();
        String gender=genderEditText.getText().toString();

        //this is insert button
        if(v.getId()==R.id.button_id){
            // rowId variable e long value store kore rakha hoiche
            // ja check korbe (rawId>0) fole bujha jabe data sothik vabe insert hoiche ki na
            /* khane (myDatabaseHelper.insert() ) method er madhome myDatadaseHelper class er insert method ke call kore data insert
            kora hoiche */
            long rowId = myDatabaseHelper.insert(name,age,gender);
            if(rowId>0){
                Toast.makeText(getApplicationContext(),"data inserted successfully ",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),"Data inserted not successfully",Toast.LENGTH_SHORT).show();
            }
        }
        // ekhane  ShowData button er kaj hosche
        if(v.getId()==R.id.show_data_id){
            // MyDatabaseHelper class er displayData() method er return kora cursor value ke ekhane cursor value er modhe store kora hosche
            Cursor cursor = myDatabaseHelper.displayData();
            // if er madhome dekha hosche database e row ache ki na ? jodi na thake tahole if block kaj korbe
            if(cursor.getCount()==0){
                showMyData("Error","No   data found");
                return;
            }

            // data base er data gula rakhar jonno stringBuffer neoya holo
            StringBuffer stringBuffer=new StringBuffer();
            /*
            *jodi database e ekadhik row thake tahole while loop totogula bar true value return korbe fole loop colte thakbe
            * joto bar loop colbe totobar stringBuffer e notun value add hobe
            */
            while (cursor.moveToNext()){
                stringBuffer.append("ID: "+cursor.getString(0)+"\n");
                stringBuffer.append("Name: "+cursor.getString(1)+"\n");
                stringBuffer.append("Age: "+cursor.getString(2)+"\n");
                stringBuffer.append("Gender: "+cursor.getString(3)+"\n\n\n");
            }
            // 97 number line e showMyData function call hobe ar function er kaj hobe
            showMyData("ResultSet",stringBuffer.toString());

        }

        // this is update button
        if(v.getId()==R.id.update_data_id){
          if(!name.trim().isEmpty()  && !age.trim().isEmpty() && !gender.trim() .isEmpty()){
              boolean isUpdated=  myDatabaseHelper.updateData(id,name,age,gender);
              if(isUpdated==true){
                  Toast.makeText(getApplicationContext(),"Updated is successful",Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(getApplicationContext(),"Updated is not successful",Toast.LENGTH_SHORT).show();
              }
          }else {
              Toast.makeText(getApplicationContext(),"Updated is not successful",Toast.LENGTH_SHORT).show();
          }

        }
        // this is delete button
        if(v.getId()==R.id.delete_data_id){
            int value=myDatabaseHelper.deleteData(id);
            if(value>0){
                Toast.makeText(getApplicationContext(),"selected data is delete",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),"data is not deleted",Toast.LENGTH_SHORT).show();
            }

        }

    }
    // alartDialog frame create hobe o er messege e upore 92 line call kora stringBuffer er data jukto hobe
    public void showMyData(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();

    }
}