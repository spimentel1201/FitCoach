package com.idnp.fitcoach;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.FirebaseApp;

public class SplashScreenActivity extends Activity {

    LottieAnimationView lottieAnimationView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        lottieAnimationView = findViewById(R.id.lottue);
        title = findViewById(R.id.title);
        //title.animate().translationY(2000).setDuration(1000).setStartDelay(5000);
        lottieAnimationView.animate().translationY(1500).setDuration(3000).setStartDelay(5000);
        //ActionBar ab = getSupportActionBar();
        //ab.hide();
        //lanzarThread();
        //Intent go = new Intent(SplashScreenActivity.this,LoginActivity.class);
        //startActivity(go);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
            }

        },4000);
    }



    /*private void lanzarThread(){
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
    }*/
}