package com.ddc.dzongkhakeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Keyboardtheme_dzo extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String THEME_KEY = "theme_key";
    private ImageView imgKt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboardtheme_dzo);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.lightorange));
        }


        imgKt=findViewById(R.id.imageactiontheme);
        imgKt.setOnClickListener(this);

        LinearLayout theme_dark = findViewById(R.id.theme_dark_layout);
        LinearLayout theme_light = findViewById(R.id.theme_light_layout);
        theme_dark.setOnClickListener(this);
        theme_light.setOnClickListener(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (view.getId() == R.id.theme_dark_layout) {
            editor.putInt(THEME_KEY, 1).apply();
            Toast.makeText(this, "དཔེ་གཞི་གནགཔོ་གདམ་ཁ་རྐྱབ་ཡོདཔ།", Toast.LENGTH_SHORT).show();

        }
        if (view.getId() == R.id.theme_light_layout) {
            editor.putInt(THEME_KEY, 0).apply();
            Toast.makeText(this, "དཔེ་གཞི་སྐྱ་བོ་གདམ་ཁ་རྐྱབ་ཡོདཔ།", Toast.LENGTH_SHORT).show();

        }
        if(view.getId() == R.id.imageactiontheme){
            onBackPressed();
        }
    }


}
