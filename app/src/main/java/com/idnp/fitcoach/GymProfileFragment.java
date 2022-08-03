package com.idnp.fitcoach;

import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.adapters.CoachsAdapter;
import com.idnp.fitcoach.adapters.GymsAdapter;
import com.idnp.fitcoach.models.Coach;
import com.idnp.fitcoach.models.Gym;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GymProfileFragment extends Fragment {

    private GymProfileViewModel mViewModel;
    private DatabaseReference database;
    private ArrayList<Coach> ListCoach = new ArrayList<>();
    private ArrayList<Coach> tmpListCoach = new ArrayList<>();
    RecyclerView listaCoachss;
    CoachsAdapter adapter;
    TextView a1;
    TextView gymName;
    TextView gymLocation;
    TextView gymCapacity;
    ImageView imageGym;
    static Integer positionn=0;

    public static GymProfileFragment newInstance() {
        return new GymProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.gym_profile_fragment, container, false);
        a1 = (TextView) view.findViewById(R.id.textGymName); //falta linkear
        gymName = (TextView) view.findViewById(R.id.textGymName);
        gymLocation = (TextView) view.findViewById(R.id.textViewGymLocation);
        gymCapacity = (TextView) view.findViewById(R.id.textViewGymCapacity);
        imageGym = (ImageView) view.findViewById(R.id.imageGym);
        database = FirebaseDatabase.getInstance().getReference();

        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String nameGym = result.getString("gymName");
                String locationGym = result.getString("gymLocation");
                String capacityGym = result.getString("gymCapacity");
                String imageURLGym = result.getString("gymImage");
                GymProfileFragment.positionn = result.getInt("gymPosition");
                gymLocation.setText(locationGym);
                gymCapacity.setText(capacityGym);
                Picasso.get().load(imageURLGym).resize(1280,720).centerCrop().into(imageGym);
                String d = Integer.toString(imageGym.getMaxHeight()) + " " + Integer.toString(imageGym.getMaxWidth());
                Log.d("testt",d);
                gymName.setText(nameGym);
            }
        });
        //Recycler view
        listaCoachss = (RecyclerView) view.findViewById(R.id.listGymTrainersCards);
        listaCoachss.setLayoutManager(new LinearLayoutManager(getContext()));
        LeerDatos();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GymProfileViewModel.class);
        // TODO: Use the ViewModel
    }

    public void LeerDatos() {
        String pos = Integer.toString(GymProfileFragment.positionn);
        //Log.d("debuger",pos);
        database.child("gyms").child("1").child("Coach").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Coach np = snapshot.getValue(Coach.class);
                    tmpListCoach.add(np);
                    Log.d("debuger",np.getSchedule());
                }
                ListCoach.clear();
                ListCoach.addAll(tmpListCoach);
                Log.d("debug","Estamos aquí entrenadores");
                //textView1.setText(ListCoach.get(3).getName());
                adapter = new CoachsAdapter(ListCoach,getContext());
                listaCoachss.setAdapter(adapter);
                listaCoachss.scrollToPosition(listaCoachss.getAdapter().getItemCount()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public Integer getPositionn(){
        return this.positionn;
    }

}