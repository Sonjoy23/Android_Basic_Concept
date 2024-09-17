package com.example.howtosentdatafromoneactivitytoanother;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class second extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView=findViewById(R.id.textId);

        //v  mainActivity theke getIntent() -----> getExtras() madhome data get kora holo
        Bundle bundle=getIntent().getExtras();
        //get kora data jodi null na hoy tahole data ke String k get kore textView e set kora holo
        if(bundle!=null){
            String value=bundle.getString("tag");
            textView.setText(value);
        }
    }
}