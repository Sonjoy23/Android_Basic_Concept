package com.example.edittext;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView v1;
    private Button b1,b2;
    private EditText e1,e2;
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
        v1=(TextView)findViewById(R.id.textView);
        b1=(Button) findViewById(R.id.addButton);
        b2=(Button) findViewById(R.id.subButton);

        e1=(EditText) findViewById(R.id.editText1);
        e2=(EditText) findViewById(R.id.editText2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        try{
            String number1=e1.getText().toString();
            String number2=e2.getText().toString();
            //converting into double
            double DoubleNumber1=Double.parseDouble(number1);
            double DoubleNumber2=Double.parseDouble(number2);
            if(v.getId()==R.id.addButton){
                double addrResult =DoubleNumber1+DoubleNumber2;
                v1.setText("Result: "+addrResult);
            } else if (v.getId()==R.id.subButton) {
                double subResult =DoubleNumber1-DoubleNumber2;
                v1.setText("Result: "+subResult);
            }
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,"Enter Right number",Toast.LENGTH_SHORT).show();
        }

    }
}