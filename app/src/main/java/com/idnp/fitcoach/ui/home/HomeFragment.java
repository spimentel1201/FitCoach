package com.idnp.fitcoach.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.GymProfileFragment;
import com.idnp.fitcoach.ItemClickListener;
import com.idnp.fitcoach.R;
import com.idnp.fitcoach.TrainerProfileFragment;
import com.idnp.fitcoach.adapters.GymsAdapter;
import com.idnp.fitcoach.databinding.ActivityHomeBinding;
import com.idnp.fitcoach.databinding.FragmentHomeBinding;
import com.idnp.fitcoach.models.Gym;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private DatabaseReference database;
    private ArrayList<Gym> ListGym = new ArrayList<>();
    private ArrayList<Gym> tmpListGym = new ArrayList<>();
    RecyclerView listaGymss;
    TextView textView1;
    GymsAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        database = FirebaseDatabase.getInstance().getReference();
        //Recycler view
        listaGymss = (RecyclerView) root.findViewById(R.id.listGymCards);
        /*listaGymss.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Create new fragment and transaction
                Fragment newFragment = new TrainerProfileFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.listGymCards , newFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });*/
        listaGymss.setLayoutManager(new LinearLayoutManager(getContext()));
        LeerDatos();
        //adapter = new GymsAdapter(ListGym, getContext());
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
                //textView1.setText(ListGym.get(3).getName());
                adapter = new GymsAdapter(ListGym, getContext(), new GymsAdapter.onTestClickListener(){

                    @Override
                    public void onClick(int position) {
                        Log.d("debud", "position = " + position);
                        Bundle bundle = new Bundle();
                        final Gym gymItem = ListGym.get(position);
                        bundle.putString("gymName",gymItem.getName().trim());
                        bundle.putString("gymImage", gymItem.getImgUrl());
                        bundle.putString("gymLocation",gymItem.getCity().trim());
                        bundle.putString("gymCapacity","50");
                        bundle.putStringArrayList("gymTrainersArray",new ArrayList<String>());
                        getParentFragmentManager().setFragmentResult("key",bundle);
                        // Create new fragment and transaction
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        // consider using Java coding conventions (upper first char class names!!!)
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        // Replace whatever is in the fragment_container view with this fragment,
                        // and add the transaction to the back stack
                        transaction.replace(R.id.nav_host_fragment_activity_home , GymProfileFragment.newInstance());
                        // Commit the transaction
                        transaction.commit();
                    }
                });
                listaGymss.setAdapter(adapter);
                //adapter.setClickListener(this);
                //Click Events
                listaGymss.scrollToPosition(listaGymss.getAdapter().getItemCount()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
/*
    @Override
    public void onClick(View view, int position) {
        Bundle bundle = new Bundle();
        final Gym gymItem = ListGym.get(position);
        bundle.putString("gymName",gymItem.getName().trim());
        bundle.putString("gymLocation",gymItem.getCity().trim());
        bundle.putString("gymCapacity","50");
        bundle.putStringArrayList("gymTrainersArray",new ArrayList<String>());
        getParentFragmentManager().setFragmentResult("key",bundle);


        //Paso 1: Obtener la instancia del administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager();

        //Paso 2: Crear una nueva transacción
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //Paso 3: Crear un nuevo fragmento y añadirlo
        GymProfileFragment fragment = new GymProfileFragment();
        transaction.add(R.id.gymProfileFra, fragment);

        //Paso 4: Confirmar el cambio
        transaction.commit();
    }*/
}