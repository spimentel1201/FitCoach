package com.idnp.fitcoach;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.MapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idnp.fitcoach.databinding.ActivityHomeBinding;
import com.idnp.fitcoach.models.Gym;
import com.idnp.fitcoach.ui.home.HomeFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    HomeFragment homeFragment = new HomeFragment();
    MapsFragment mapFragment = new MapsFragment();
    RoutinesFragment routinesFragment = new RoutinesFragment();
    SurveyFragment surveyFragment = new SurveyFragment();
    UserProfileFragment userProfileFragment = new UserProfileFragment();
    DietFragment dietFragment = new DietFragment();
    TrainerProfileFragment trainerProfileFragment = new TrainerProfileFragment();
    private DatabaseReference database;
    private FirebaseAuth firebaseAuth;
    private ArrayList<Gym> ListGym = new ArrayList<>();
    private ArrayList<Gym> tmpListGym = new ArrayList<>();
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        ActionBar ab = getSupportActionBar();
        ab.hide();
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();
        //LeerDatos();
        /*database.child("gyms").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);*/

        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(homeFragment);
    }

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser==null){
            startActivity(new Intent(this,LoginActivity.class));
        }else{
            String email = firebaseUser.getEmail();
            String name = firebaseUser.getDisplayName();

        }
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    loadFragment(homeFragment);
                    return true;
                case R.id.navigation_Routines:
                    loadFragment(routinesFragment);
                    return true;
                case R.id.navigation_Maps:
                    loadFragment(surveyFragment);
                    return true;
                case R.id.navigation_Diet:
                    loadFragment(dietFragment);
                    return true;
                case R.id.navigation_UserProfile:
                    loadFragment(userProfileFragment);

            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //fragment.setArguments(val);
        transaction.replace(R.id.nav_host_fragment_activity_home,fragment);
        transaction.commit();
    }

    public void LeerDatos() {

        database.child("gyms").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Gym np = snapshot.getValue(Gym.class);
                    ListGym.add(np);
                }
                ListGym.clear();
                ListGym.addAll(tmpListGym);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void goTo(View view){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentHome, trainerProfileFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}