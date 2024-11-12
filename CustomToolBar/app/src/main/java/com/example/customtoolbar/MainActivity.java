package com.example.customtoolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

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


        //ekhan theke toolBar er kaj suru holo
        toolbar=findViewById(R.id.toolbarId);
             // setSupportActionBar() eita must dite hobe na dile Support pawa jabe na
        // step one
        setSupportActionBar(toolbar);

        // step two
        //eita deoyar karone ToolBar er modhe BackIcon add hobe( <-  )
        if(getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // ekhane Toolbar er modhe Title r subTitle set kora holo
        toolbar.setTitle("Main Title");
        toolbar.setSubtitle("Sub Title");


    }

    //---------->>>>>>>>>
    // nicher code block ta te ToolBar e menu niye kaj kora hoiche
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.newId){
            Toast.makeText(MainActivity.this,"Clicked new file",Toast.LENGTH_SHORT).show();
        }
        if(itemId==R.id.openId){
            Toast.makeText(MainActivity.this,"Clicked Open file",Toast.LENGTH_SHORT).show();
        }
        if(itemId==R.id.saveId){
            Toast.makeText(MainActivity.this,"Clicked Save file",Toast.LENGTH_SHORT).show();
        }
        // ToolBar er BackIcon e click kora hole eita kaj korbe
        // BackIcon er id android er modhe byedefult vabe home deoya thake
        if(itemId==android.R.id.home){
            //super.onBackPressed() ei method bebohar er karone backicon e click kora matro main activity kete jabe
            // jehetu method ta main.activity er ToolBar e call kora hoiche
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}