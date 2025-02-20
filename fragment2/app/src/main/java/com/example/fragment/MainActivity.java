package com.example.fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        String[] name={"Sonjoy","Rifat","Mostafizul","Faysal","Korim","Raju","Hana"};
        listView=findViewById(R.id.listViewId);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    /*
    fragment e kaj kora somoy sobceye gurutopurno holo Fragment import kora
    amra jei(import androidx.fragment.app.Fragment;) fragment main java file import korbe seita sobgulate
    import korte hobe

     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment;
        if(position==0){
           fragment=new sojoy_fragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentId,fragment);
            fragmentTransaction.commit();

        } else if (position==1) {
            //---> object call
            MyObj( new rifat_fragment());
            // fragment=new rifat_fragment();
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,new sojoy_fragment()).commit();
        }
    }

    // niche object or madhome kaj korechi

    public void MyObj(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentId,fragment);
        fragmentTransaction.commit();

    }
}