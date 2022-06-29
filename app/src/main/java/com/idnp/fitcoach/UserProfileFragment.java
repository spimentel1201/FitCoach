package com.idnp.fitcoach;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.models.Gym;

import java.util.ArrayList;

public class UserProfileFragment extends Fragment {

    private UserProfileViewModel mViewModel;
    private DatabaseReference database;
    private ArrayList<Gym> ListGym = new ArrayList<>();
    private ArrayList<Gym> tmpListGym = new ArrayList<>();
    TextView a1;

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile_fragment, container, false);

        a1 = (TextView) view.findViewById(R.id.textUserNameP);
        database = FirebaseDatabase.getInstance().getReference();
        LeerDatos();
        //a1.setText(ListGym.get(3).getName());
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        // TODO: Use the ViewModel
    }

    public void LeerDatos() {

        database.child("gyms").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Gym np = snapshot.getValue(Gym.class);
                    tmpListGym.add(np);
                    Log.d("debug",np.getName());
                }
                ListGym.clear();
                ListGym.addAll(tmpListGym);
                Log.d("debug","Estamos aquí");
                a1.setText(ListGym.get(3).getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}