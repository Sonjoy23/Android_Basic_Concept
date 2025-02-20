package com.example.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.BitmapCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID="my channel";

    private static final int NOTIFICATION_ID=100;

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

        // ekhane image ke bitmap e rupantor kora hoiche setLargeIcon e bebohar korar jonno
        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.png_icon,null);
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        Bitmap largeIcon=bitmapDrawable.getBitmap();
        //________________________________________________________________________________________________

        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;
        // if block o condition diye varsion control kora hoiche
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification=new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.baseline_edit_notifications_24)
                    .setContentText("New message")
                    .setSubText("New Message from Sonjoy")
                    .setChannelId(CHANNEL_ID)
                    // build method dara notification build kora hoiche
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"new channel",NotificationManager.IMPORTANCE_HIGH ));
        } else{
            notification=new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.baseline_edit_notifications_24)
                    .setContentText("New message")
                    .setSubText("New Message from Sonjoy")
                    .build();

        }
        nm.notify(NOTIFICATION_ID,notification);

    }
}