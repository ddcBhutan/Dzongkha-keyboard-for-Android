package com.ddc.dzongkhakeyboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class about_dzo extends AppCompatActivity implements
        View.OnClickListener {
    ImageView imgview;
    ImageView imgview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dzo);

        imgview = findViewById(R.id.imgshare);
        imgview1 = findViewById(R.id.imgrate);

        imgview.setOnClickListener(this);
        imgview1.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.lightorange));
        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.aboutid);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeid:
                        startActivity(new Intent(getApplicationContext(), MainActivity_dzo.class));
                        finish();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.aboutid:

                        break;
                }
                return true;
            }

        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

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
                } catch (ActivityNotFoundException e) {
                    Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }


            default:
                break;

        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity_dzo.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    public void onClick2(View view) {
        sendEmail("mgkums@gmail.com");
    }

    public void onClick3(View view) {
       sendEmail("rinchenw1999@gmail.com");
    }

    public void onClick1(View view) {
       sendEmail("kezang.sherab20@gmail.com");
    }

    public void onClick4(View view) {
       sendEmail("yjamtsho.cst@rub.edu.bt");
    }


    protected void sendEmail(String to) {

        String[] TO = {to};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail to developer..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}