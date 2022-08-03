package com.idnp.fitcoach;

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
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.adapters.RoutinesAdapter;
import com.idnp.fitcoach.models.Routine;

import java.util.ArrayList;

public class RoutinesFragment extends Fragment {

    private RoutinesViewModel mViewModel;
    private DatabaseReference database;
    private ArrayList<Routine> ListRoutine = new ArrayList<>();
    private ArrayList<Routine> tmpListRoutine = new ArrayList<>();
    RecyclerView listaRoutiness;
    TextView textView1;
    RoutinesAdapter adapter;

    public static RoutinesFragment newInstance() {
        return new RoutinesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        database = FirebaseDatabase.getInstance().getReference();
        View view =  inflater.inflate(R.layout.fragment_routines, container, false);
        listaRoutiness = (RecyclerView) view.findViewById(R.id.listRoutineUser);
        listaRoutiness.setLayoutManager(new LinearLayoutManager(getContext()));
        LeerDatos();
        return view;
        //Recycler view
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RoutinesViewModel.class);
        // TODO: Use the ViewModel
    }

    public void LeerDatos() {

        database.child("routines").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Routine np = snapshot.getValue(Routine.class);
                    tmpListRoutine.add(np);
                    assert np != null;
                    Log.d("debugRoutine",np.getDescription());
                }
                ListRoutine.clear();
                ListRoutine.addAll(tmpListRoutine);
                Log.d("debug","Estamos en Rutinas");
                adapter = new RoutinesAdapter(ListRoutine, getContext());
                listaRoutiness.setAdapter(adapter);
                listaRoutiness.scrollToPosition(listaRoutiness.getAdapter().getItemCount()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}