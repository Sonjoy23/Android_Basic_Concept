package com.example.recycler_view_update_and_delete;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<control_model> arrayList=new ArrayList<>();

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
        RecyclerView recyclerView=findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList.add(new control_model("Sonjoy","616396"));
        arrayList.add(new control_model("Sadik","616398"));
        arrayList.add(new control_model("Korim","616399"));
        arrayList.add(new control_model("Rifat","616400"));
        arrayList.add(new control_model("Emran","616404"));
        arrayList.add(new control_model("Siyam","616405"));
        arrayList.add(new control_model("Ronju","616406"));
        arrayList.add(new control_model("Masrup","616407"));
        arrayList.add(new control_model("Rohul","616408"));
        arrayList.add(new control_model("Nayim","616409"));
        arrayList.add(new control_model("Gopal","616410"));
        arrayList.add(new control_model("Alamin","616411"));
        arrayList.add(new control_model("Sakil","616412"));
        arrayList.add(new control_model("Jasmin","616413"));
        arrayList.add(new control_model("Tritha","616414"));
        arrayList.add(new control_model("Shohag","616415"));
        arrayList.add(new control_model("Niami","616416"));
        arrayList.add(new control_model("Digonto","616418"));
        arrayList.add(new control_model("Nirob","616419"));
        arrayList.add(new control_model("Shorat","616420"));

        RecyclerContactAdapter adapter=new RecyclerContactAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

        // add new item
        FloatingActionButton floatingActionButton=findViewById(R.id.floatingActionButtonId);

        // notun data add korar somoy eita kaj korbe
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_layout);
                Button addButton=dialog.findViewById(R.id.addId);
                // dialog box ke adjust korar jonno nicher line lekha hoiche
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean AddEmptyName =false;
                        boolean AddEmptyNumber=false;
                        String Editname="", Editnumber="";
                        EditText inputName=dialog.findViewById(R.id.inputNameId);
                        EditText inputNumber=dialog.findViewById(R.id.inputNumberId);
                        if(!inputName.getText().toString().equals("")){
                            Editname=inputName.getText().toString();
                            AddEmptyName=true;

                        }else{
                            Toast.makeText(MainActivity.this,"Plase Enter Name",Toast.LENGTH_SHORT).show();
                        }
                        if(!inputNumber.getText().toString().equals("")){
                            Editnumber=inputNumber.getText().toString();
                            AddEmptyNumber=true;
                        }else{
                            Toast.makeText(MainActivity.this,"Plase Enter Number",Toast.LENGTH_SHORT).show();
                        }
                        // ei condition deoyar koron EditName r EditNumber 2 EditText value deoya pore notun item add korbe
                        if(AddEmptyName==true && AddEmptyNumber==true){
                            arrayList.add(new control_model(Editname,Editnumber));
                            adapter.notifyItemInserted(arrayList.size()-1);
                            recyclerView.scrollToPosition(arrayList.size()-1);
                        }




                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });



    }
}