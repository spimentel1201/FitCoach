package com.idnp.fitcoach;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeekStatsGraphicFragment extends Fragment {

    private WeekStatsGraphicViewModel mViewModel;

    public static WeekStatsGraphicFragment newInstance() {
        return new WeekStatsGraphicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_week_stats_graphic, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WeekStatsGraphicViewModel.class);
        // TODO: Use the ViewModel
    }

}