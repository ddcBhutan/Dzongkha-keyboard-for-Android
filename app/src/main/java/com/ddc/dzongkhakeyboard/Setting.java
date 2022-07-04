package com.ddc.dzongkhakeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Setting extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private Switch switchsound;
    private Switch switchvibrate;
    Button keyboardthemebtn;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String SOUND_KEY = "sound_key";
    private static final String VIBRATION_KEY = "vibration_key";
    private boolean vibrationOn;
    private boolean soundOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportActionBar().setTitle("Keyboard Setting");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_backarr);

        keyboardthemebtn=findViewById(R.id.themebtn);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        vibrationOn = sharedPreferences.getBoolean(VIBRATION_KEY,false);
        soundOn = sharedPreferences.getBoolean(SOUND_KEY,false);

        switchsound = findViewById(R.id.switch3);
        switchsound.setChecked(soundOn);

        switchvibrate = findViewById(R.id.switch2);
        switchvibrate.setChecked(vibrationOn);
        switchsound.setOnCheckedChangeListener(this);
        switchvibrate.setOnCheckedChangeListener(this);

        keyboardthemebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Keyboardtheme.class);

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

