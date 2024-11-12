package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;

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
        spinner=findViewById(R.id.spinnerId);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Bangladesh");
        arrayList.add("India");
        arrayList.add("Pakistan");
        arrayList.add("Nepal");
        arrayList.add("China");
        arrayList.add("Indonesia");
        arrayList.add("Japan");
        arrayList.add("Iran");
        arrayList.add("Turkey");
        arrayList.add("Thailand");
        arrayList.add("Myanmar");
        arrayList.add("South Korea");
        arrayList.add("Iraq");
        arrayList.add("Sri Lanka");
        arrayList.add("Malaysia");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,arrayList);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=arrayList.get(position);
                Toast.makeText(MainActivity.this,"you selected "+value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}