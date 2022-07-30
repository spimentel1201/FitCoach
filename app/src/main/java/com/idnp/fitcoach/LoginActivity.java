package com.idnp.fitcoach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends Activity {
    private static final String TAG = "";
    EditText userLogin, passwordLogin;
    private FirebaseAuth firebaseAuth;
    private final static int RC_SIGN_IN = 123;
    private GoogleSignInClient mGoogleSignInClient;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = database.child("profiles");
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();
        userLogin = (EditText) findViewById(R.id.textEmailUserL);
        passwordLogin = (EditText) findViewById(R.id.textPasswordUserL);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Cargando");
        progressDialog.setMessage("Iniciando Sesión");
    }

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }
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
    /*Inicio de Sesión con Cuenta Google*/
    public void iniciarSesionGoogle(View view){
        if(userLogin.getText().toString() != null && passwordLogin.getText().toString() != null){
            inicioSesion(userLogin.getText().toString(),passwordLogin.getText().toString());
        }
    }

    public void inicioSesion(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {

                    }
                });
    }

    public void inicioSesionF(View view){
        firebaseAuth.signInWithEmailAndPassword(userLogin.getText().toString(), passwordLogin.getText().toString()).
                addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                        String email = firebaseUser.getEmail();
                        Toast.makeText(LoginActivity.this,email+" logueado", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this,""+ e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}