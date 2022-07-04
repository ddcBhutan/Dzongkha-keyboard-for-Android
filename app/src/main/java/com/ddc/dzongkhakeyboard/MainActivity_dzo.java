package com.ddc.dzongkhakeyboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity_dzo extends AppCompatActivity implements
        View.OnClickListener,CompoundButton.OnCheckedChangeListener {
    Button enableSetting;
    Button addkeyboards;
    Button setting;
    private Switch bSwitch;
    SharedPreferences sharedPreferences;
    private static final String DEFAULT_KEYBOARD = "default_keyboard";
    ImageView imgview;
    ImageView imgview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dzo);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        imgview=findViewById(R.id.imgshare);
        imgview1=findViewById(R.id.imgrate);

        enableSetting = findViewById(R.id.keyboard_button);
        addkeyboards = findViewById(R.id.edit_button);
        setting = findViewById(R.id.setting);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.lightorange));
        }

        imgview.setOnClickListener(this);
        imgview1.setOnClickListener(this);

        enableSetting.setOnClickListener(this);
        addkeyboards.setOnClickListener(this);
        setting.setOnClickListener(this);

        bSwitch =findViewById(R.id.switch1);
        bSwitch.setTypeface(ResourcesCompat.getFont(this, R.font.source_serif_pro));
        bSwitch.setChecked(sharedPreferences.getBoolean(DEFAULT_KEYBOARD,true));
        bSwitch.setOnCheckedChangeListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.homeid);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public  boolean onNavigationItemSelected (MenuItem item){
                switch (item.getItemId()){
                    case R.id.homeid:
                        break;
                    case R.id.aboutid:
                        startActivity(new Intent(getApplicationContext(),about_dzo.class));
                        finish();
                        overridePendingTransition(0,0);
                        break;
                }
                return  true;
            }

        });
    }
//
//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setMessage("ཐད་རི་བ་རི་རིམ་ལུགས་འདི་བསྡམ་ནི་ཨིན་ན?")
//                .setCancelable(false)
//                .setPositiveButton("ཨིན།", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        finish();
//
//                    }
//                })
//                .setNegativeButton("མེན།\n", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//
//    }
//
//
//
    @Override
    public void onCheckedChanged (CompoundButton buttonView,boolean isChecked) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (buttonView.getId()) {
            case R.id.switch1:
                if (isChecked)
                    return;
                else
                    editor.putBoolean(DEFAULT_KEYBOARD,isChecked);
                editor.apply();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(0,0);
                finish();
                break;
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.keyboard_button:
                startActivityForResult(
                        new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS), 0);
                break;
            case R.id.edit_button:

                ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                        .showInputMethodPicker();

                break;
            case R.id.setting:
                startActivity(new Intent(this, Setting_dzo.class));
                overridePendingTransition(0,0);
                break;
            case R.id.imgshare:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);

                // type of the content to be shared
                sharingIntent.setType("text/plain");

                // Body of the content
                String shareBody = "Dzongkha Keyboard Application Link here";

                // subject of the content. you can share anything
                String shareSubject = "Android Based Dzongkha Keyboard";

                // passing body of the content
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                // passing subject of the content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share Via"));
                break;
            case R.id.imgrate:
                try {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }


            default:
                break;

        }

    }
}