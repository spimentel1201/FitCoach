package com.idnp.fitcoach.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.R;
import com.idnp.fitcoach.adapters.GymsAdapter;
import com.idnp.fitcoach.databinding.ActivityHomeBinding;
import com.idnp.fitcoach.databinding.FragmentHomeBinding;
import com.idnp.fitcoach.models.Gym;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

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
        listaGymss.setLayoutManager(new LinearLayoutManager(getContext()));
        LeerDatos();
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
                adapter = new GymsAdapter(ListGym);
                listaGymss.setAdapter(adapter);
                listaGymss.scrollToPosition(listaGymss.getAdapter().getItemCount()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}