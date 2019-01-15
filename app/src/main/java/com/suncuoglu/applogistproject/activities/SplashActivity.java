package com.suncuoglu.applogistproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.suncuoglu.applogistproject.R;

public class SplashActivity extends AppCompatActivity {
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
        startActivity(new Intent(SplashActivity.this,MovieActivity.class));
        finish();
        }
    };

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        handler.postDelayed(runnable,1500);
    }
}