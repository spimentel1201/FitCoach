package com.idnp.fitcoach;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.idnp.fitcoach.adapters.PagerAdapter;

public class UserStatisticsFragment extends Fragment {

    private UserStatisticsViewModel mViewModel;

    public static UserStatisticsFragment newInstance() {
        return new UserStatisticsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_statistics_fragment, container, false);

        TabLayout tabLayoutStats = (TabLayout) getView().findViewById(R.id.tabsStats);
        TabItem tabItemWeek = (TabItem) getView().findViewById(R.id.tabWeek);
        TabItem tabItemMonth = (TabItem) getView().findViewById(R.id.tabMonth);
        ViewPager viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayoutStats.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayoutStats.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return  view;
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserStatisticsViewModel.class);
        // TODO: Use the ViewModel
    }

}