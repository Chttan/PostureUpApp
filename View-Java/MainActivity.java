package com.example.postureup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
    }

    public void startMonitor(View view) {
        Intent intent = new Intent(this, MonitorActivity.class);
        startActivity(intent);
    }

    public void startFeedback(View view) {
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }

    public void startSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
