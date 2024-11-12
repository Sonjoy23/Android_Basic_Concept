package com.example.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<controlModel> arrayList=new ArrayList<>();

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

        RecyclerView recyclerView=  findViewById(R.id.recyclerViewId);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList.add(new controlModel("Sonjoy","616396"));
        arrayList.add(new controlModel("Sadik","616398"));
        arrayList.add(new controlModel("Korim","616399"));
        arrayList.add(new controlModel("Rifat","616400"));
        arrayList.add(new controlModel("Emran","616404"));
        arrayList.add(new controlModel("Siyam","616405"));
        arrayList.add(new controlModel("Ronju","616406"));
        arrayList.add(new controlModel("Masrup","616407"));
        arrayList.add(new controlModel("Rohul","616408"));
        arrayList.add(new controlModel("Nayim","616409"));
        arrayList.add(new controlModel("Gopal","616410"));
        arrayList.add(new controlModel("Alamin","616411"));
        arrayList.add(new controlModel("Sakil","616412"));
        arrayList.add(new controlModel("Jasmin","616413"));
        arrayList.add(new controlModel("Tritha","616414"));
        arrayList.add(new controlModel("Shohag","616415"));
        arrayList.add(new controlModel("Niami","616416"));
        arrayList.add(new controlModel("Digonto","616418"));
        arrayList.add(new controlModel("Nirob","616419"));
        arrayList.add(new controlModel("Shorat","616420"));


        RecyclerContactAdapter adapter=new RecyclerContactAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

    }
}