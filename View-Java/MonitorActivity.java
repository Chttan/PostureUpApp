package com.example.postureup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.CountDownTimer;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MonitorActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "the channel";
    private boolean isRecording = false;
    private int secondsoffAngle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        createNotificationChannel();
    }

    public void toggleMonitor(View view) {
        Button but = (Button)findViewById(R.id.button3);
        EditText tv = (EditText) findViewById(R.id.editText2);
        EditText tv_wrong = (EditText) findViewById(R.id.editText3);

        if (isRecording)
        {
            isRecording = false;
            but.setText(getString(R.string.start_string));
            tv.setText("");
            tv_wrong.setText("");
        }
        else
        {
            isRecording = true;
            but.setText(getString(R.string.stop_string));
            tv.setText(new SimpleDateFormat("HH:mm", Locale.US).format(new Date()));

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_error_24px)
                    .setContentTitle("PostureUp")
                    .setContentText("Incorrect Posture Detected - Please Adjust!")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            int notificationId = 1;
            // notificationId is a unique int for each notification that you must define
            notificationManager.notify(notificationId, builder.build());

        }
    }

    public void calibrateAccel(View view) {

        //EditText et = (EditText) findViewById(R.id.editText);
        //et.setText(Double.toString(random));
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notif_channel";
            String description = "channel for notifs";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}


