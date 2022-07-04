package com.ddc.dzongkhakeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Keyboardtheme extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String THEME_KEY = "theme_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboardtheme);

        getSupportActionBar().setTitle("Keyboard Theme");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_backarr);

        LinearLayout theme_dark = findViewById(R.id.theme_dark_layout);
        LinearLayout theme_light = findViewById(R.id.theme_light_layout);
        theme_dark.setOnClickListener(this);
        theme_light.setOnClickListener(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

//        CountDownTimer cdt = new CountDownTimer(3000,1000) {
//            @Override
//            public void onTick(long l) {
//                toast.show();
//
//            }
//
//            @Override
//            public void onFinish() {
//                toast.cancel();
//
//            }
//        };
//        cdt.start();
        if (view.getId() == R.id.theme_dark_layout) {
            editor.putInt(THEME_KEY, 1).apply();
            Toast.makeText(this,"Dark theme sellected successfully!",Toast.LENGTH_SHORT).show();



        }
        if (view.getId() == R.id.theme_light_layout) {
            editor.putInt(THEME_KEY, 0).apply();
            Toast.makeText(this,"Light theme sellected successfully!",Toast.LENGTH_SHORT).show();

        }
    }


}

