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
import com.idnp.fitcoach.adapters.DietsAdapter;
import com.idnp.fitcoach.models.Diet;

import java.util.ArrayList;

public class DietFragment extends Fragment {

    private DietViewModel mViewModel;
    private DatabaseReference database;
    private ArrayList<Diet> ListDiet = new ArrayList<>();
    private ArrayList<Diet> tmpListDiet = new ArrayList<>();
    RecyclerView listaDietss;
    TextView textView1;
    DietsAdapter adapter;

    public static DietFragment newInstance() {
        return new DietFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        database = FirebaseDatabase.getInstance().getReference();
        View view =  inflater.inflate(R.layout.diet_fragment, container, false);
        listaDietss = (RecyclerView) view.findViewById(R.id.listDietUser);
        listaDietss.setLayoutManager(new LinearLayoutManager(getContext()));
        LeerDatos();
        return view;
        //Recycler view

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DietViewModel.class);
        // TODO: Use the ViewModel
    }

    public void LeerDatos() {

        database.child("diestas").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Diet np = snapshot.getValue(Diet.class);
                    tmpListDiet.add(np);
                    assert np != null;
                    Log.d("debugger",np.getBreakfast());
                }
                ListDiet.clear();
                ListDiet.addAll(tmpListDiet);
                Log.d("debug","Estamos aquí");
                //textView1.setText(ListDiet.get(3).getName());
                adapter = new DietsAdapter(ListDiet, getContext());
                listaDietss.setAdapter(adapter);
                listaDietss.scrollToPosition(listaDietss.getAdapter().getItemCount()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}