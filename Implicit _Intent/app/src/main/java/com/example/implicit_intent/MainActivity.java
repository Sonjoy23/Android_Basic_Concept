package com.example.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button dialBtn, messageBtn, emailBtn,shareBtn;
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
        dialBtn=findViewById(R.id.button1);
        messageBtn=findViewById(R.id.button2);
        emailBtn=findViewById(R.id.button3);
        shareBtn=findViewById(R.id.button4);

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial=new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +88017919861"));
                startActivity(iDial);

            }
        });

        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IMessage =new Intent(Intent.ACTION_SENDTO);
                IMessage.setData(Uri.parse("smsto:"+Uri.encode("+8801740919861")));
                IMessage.putExtra("sms_body","This is sms body ");
                startActivity(IMessage);

            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail=new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"abc@gmail.com","xyz@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"hello my name is sonjoy das. i am from bangladesh");
                startActivity(Intent.createChooser(iEmail,"Email Via"));

            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare=new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"HI my name is sonjoy das. this app is good plz install the app,");
                startActivity(Intent.createChooser(iShare,"Share Via"));


            }
        });
    }
}