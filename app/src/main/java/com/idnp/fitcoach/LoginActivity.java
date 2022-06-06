package com.idnp.fitcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*Botón de redirección a registro*/
    public void irRegistrarme(View view){
        Intent go = new Intent(this,SignUpActivity.class);
        startActivity(go);
    }

    /*Botón de redirección a registro*/
    public void iniciarSesion(View view){
        Intent go = new Intent(this,HomeActivity.class);
        startActivity(go);
    }
}