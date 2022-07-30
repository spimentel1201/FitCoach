package com.idnp.fitcoach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends Activity {
    private static final String TAG = "";
    EditText nameU,lastnameU,emailU,passU;
    FirebaseAuth firebaseAuth;
    private DatabaseReference database;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameU = (EditText) findViewById(R.id.textUserName);
        lastnameU = (EditText) findViewById(R.id.textUserLastName);
        emailU = (EditText) findViewById(R.id.textUserEmailR);
        passU = (EditText) findViewById(R.id.textPasswordUserR);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Espere");
        progressDialog.setMessage("Creando Cuenta");
        database = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
    /*Redireccionar a Home*/
    public void signUpGo(){
        Intent gow = new Intent(this, HomeActivity.class);
        startActivity(gow);
    }
    public void signUp(View view){
        progressDialog.show();
        if(nameU.getText().toString() != null && emailU.getText().toString() != null && passU.getText().toString() != null){
            firebaseAuth.createUserWithEmailAndPassword(emailU.getText().toString(), passU.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            progressDialog.dismiss();
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            String email = firebaseUser.getEmail();
                            Toast.makeText(SignUpActivity.this,"Cuenta creada", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(SignUpActivity.this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }
    public void signUpL(View view){
        /*if ( emailU.getText() == null || !Patterns.EMAIL_ADDRESS.matcher(emailU.getText()).matches()){

            return;
        }
        if ( passU.getText() == null || passU.getText().length()<=4 ){

            return;
        }
        Map<String, Object> user = new HashMap<>();
        user.put("name", nameU.getText().toString() +" "+ lastnameU.getText().toString());
        user.put("gmail", emailU.getText().toString());
        user.put("password", passU.getText().toString());

        database.child("user")
                .document(correo.getValue().toString())
                .set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        databaseError.setValue(new Event<>(R.string.registro_exitoso));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        databaseError.setValue(new Event<>(R.string.registro_error));
                    }
                });*/
    }

    public void registrarSesion(){

    }
    private void reload() {
        signUpGo();
    }
}