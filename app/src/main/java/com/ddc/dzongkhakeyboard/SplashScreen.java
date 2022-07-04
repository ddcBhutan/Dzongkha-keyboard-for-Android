package com.ddc.dzongkhakeyboard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    private static final String DEFAULT_KEYBOARD = "default_keyboard";

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sharedPreferences.getBoolean(DEFAULT_KEYBOARD,false)){
                    Intent intent=new Intent(SplashScreen.this,MainActivity_dzo.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    finish();
                }
                else{
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    finish();

                }
            }
        },1000);

    }
}