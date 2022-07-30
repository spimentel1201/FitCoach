package com.idnp.fitcoach;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.models.User;

import java.util.ArrayList;

public class UserProfileFragment extends Fragment {

    private UserProfileViewModel mViewModel;
    private DatabaseReference database;
    private FirebaseAuth firebaseAuth;
    private ArrayList<User> ListUser = new ArrayList<>();
    private ArrayList<User> tmpListUser = new ArrayList<>();
    TextView a1,a2,a3;
    Button signoutbtn;

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile_fragment, container, false);

        a1 = (TextView) view.findViewById(R.id.textUserNameP);
        a2 = (TextView) view.findViewById(R.id.textUserEmailP);
        a3 = (TextView) view.findViewById(R.id.textUserSexP);
        signoutbtn = (Button) view.findViewById(R.id.buttonSignOut);
        database = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        a1.setText(firebaseUser.getDisplayName());
        a2.setText(firebaseUser.getEmail());

        signoutbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                firebaseAuth.signOut();
                checkUser();
            }
        });

        //LeerDatos();
        //a1.setText(ListUser.get(3).getName());
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        // TODO: Use the ViewModel
    }

    public void LeerDatos() {

        database.child("Coachs").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User np = snapshot.getValue(User.class);
                    tmpListUser.add(np);
                    Log.d("debug",np.getName());
                }
                ListUser.clear();
                ListUser.addAll(tmpListUser);
                Log.d("debug","Estamos aquí");
                a1.setText(ListUser.get(3).getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser==null){
            startActivity(new Intent(this.getContext(),LoginActivity.class));
        }else{

        }
    }

}