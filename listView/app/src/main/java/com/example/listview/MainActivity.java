package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

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

        listView=findViewById(R.id.listViewId);
        ArrayList<String> array=new ArrayList<String>();
        array.add("sonjoy");
        array.add("rifat");
        array.add("korim");
        array.add("nimai");
        array.add("polash");
        array.add("jannati");
        array.add("jui");
        array.add("raju");
        array.add("rahad");
        array.add("nayim");
        array.add("mahedi");
        array.add("rami");
        array.add("marufa");
        array.add("alamin");
        array.add("sonjoy");
        array.add("rifat");
        array.add("korim");
        array.add("nimai");
        array.add("polash");
        array.add("jannati");
        array.add("jui");
        array.add("raju");
        array.add("rahad");
        array.add("nayim");
        array.add("mahedi");
        array.add("rami");
        array.add("marufa");
        array.add("alamin");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,array);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value =array.get(position);
                Toast.makeText(MainActivity.this,"you click "+value,Toast.LENGTH_SHORT).show();

            }
        });

    }
}