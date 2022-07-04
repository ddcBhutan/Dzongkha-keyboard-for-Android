package com.ddc.dzongkhakeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class Setting_dzo extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private Switch switchsound;
    private Switch switchvibrate;
    private ImageView imgKt;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String SOUND_KEY = "sound_key";
    private static final String VIBRATION_KEY = "vibration_key";
    private boolean vibrationOn;
    private boolean soundOn;
    Button keyboardthemebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_dzo);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.lightorange));
        }


        imgKt=findViewById(R.id.imageaction);
        imgKt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        vibrationOn = sharedPreferences.getBoolean(VIBRATION_KEY,false);
        soundOn = sharedPreferences.getBoolean(SOUND_KEY,false);

        switchsound = findViewById(R.id.switch3);
        switchsound.setChecked(soundOn);

        switchvibrate = findViewById(R.id.switch2);
        switchvibrate.setChecked(vibrationOn);
        switchsound.setOnCheckedChangeListener(this);
        switchvibrate.setOnCheckedChangeListener(this);




        keyboardthemebtn=findViewById(R.id.themebtn);
        keyboardthemebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_dzo.this, Keyboardtheme_dzo.class);

                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (compoundButton.getId()) {
            case R.id.switch2:
                if (b){
                    editor.putBoolean(VIBRATION_KEY, true).apply();

                }
                else{
                    editor.putBoolean(VIBRATION_KEY, false).apply();

                }
            case R.id.switch3:
                if (b){
                    editor.putBoolean(SOUND_KEY, true).apply();

                }
                else{
                    editor.putBoolean(SOUND_KEY, false).apply();
                }


        }
    }
}
