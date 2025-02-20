package com.example.bottomnavigationview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

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
        bottomNavigationView=findViewById(R.id.BtnNavigaitionViewId);
        frameLayout=findViewById(R.id.containerId);
        /*
         bottomNavigationView.setOnNavigationItemSelectedListener() ei method er madhome amra BottomNavigationView
         er jei item e click korbo seita bujha jabe
         */

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.item_home){
                    loadFragment(new HomeFragment(),false);
                } else if (id==R.id.item_search) {
                    loadFragment(new SearchFragment(),false);
                } else if (id==R.id.item_setting) {
                    loadFragment(new SettingFragment(),false);

                } else if (id==R.id.item_contact) {
                    loadFragment(new ContactFragment(),false);

                }else {
                    loadFragment(new ProfileFragment(),true);
                }

                // ekhane return false thakbe seita true kore dite hobe er fole BottomNavigationView e kon
                // item select hoye ache ta bujha jabe
                return true;

            }

        });
        // setSelectedItemId er madhome amra jekono framgent ke FrameLayout e default vabe select kore rachte parbo
        bottomNavigationView.setSelectedItemId(R.id.item_attribution);




    }
    /*
    loadFragment method  er madhome bibhinno fragment ke Framelayout (R.id.containerId) er medhe
    set  kora hosche
     */
    public void loadFragment(Fragment fragment, boolean flag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(flag==true){
            fragmentTransaction.add(R.id.containerId,fragment);
        }else{
            fragmentTransaction.replace(R.id.containerId,fragment);
        }
        fragmentTransaction.commit();
    }

}