package com.idnp.fitcoach;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        lanzarThread();
        Intent go = new Intent(SplashScreenActivity.this,LoginActivity.class);
        startActivity(go);
    }

    private void lanzarThread(){
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(8000); //espera de 8 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                }
            }
        };

        timer.start();
    }
}