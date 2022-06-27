package com.idnp.fitcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = database.child("profiles");
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