package com.idnp.fitcoach;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.models.Coach;
import com.idnp.fitcoach.models.User;

import java.util.ArrayList;

public class TrainerProfileFragment extends Fragment {

    private TrainerProfileViewModel mViewModel;
    private DatabaseReference database;
    private ArrayList<Coach> ListCoach = new ArrayList<>();
    private ArrayList<Coach> tmpListCoach = new ArrayList<>();
    TextView textViewTrainerName, textViewTrainerSchedule, textViewTrainerDays, textViewTrainerDomain;
    ImageView imageViewCoachT;
    
    public static TrainerProfileFragment newInstance() {
        return new TrainerProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.trainer_profile_fragment, container, false);
        textViewTrainerName = (TextView) view.findViewById(R.id.textViewTrainerName);
        textViewTrainerSchedule = (TextView) view.findViewById(R.id.textViewTrainerSchedule);
        textViewTrainerDays = (TextView) view.findViewById(R.id.textViewTrainerDays);
        textViewTrainerDomain = (TextView) view.findViewById(R.id.textViewTrainerDomain);
        imageViewCoachT = (ImageView) view.findViewById(R.id.imageViewCoachT);
        database = FirebaseDatabase.getInstance().getReference();
        LeerDatosTrainer();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TrainerProfileViewModel.class);
        // TODO: Use the ViewModel
    }

    public void LeerDatosTrainer() {
        database.child("gyms").child("Coach").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String idCoach = dataSnapshot.child("CO_01").getValue().toString();
                    Log.d("debug", idCoach);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /*
        database.child("Coachs").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Coach np = snapshot.getValue(Coach.class);
                    tmpListCoach.add(np);
                    Log.d("debug",np.getName());
                }
                ListCoach.clear();
                ListCoach.addAll(tmpListCoach);
                Log.d("debug","Estamos aquí");
                textViewTrainerName.setText(ListCoach.get(0).getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/


    }

}