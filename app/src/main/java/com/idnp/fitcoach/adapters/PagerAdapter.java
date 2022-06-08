package com.idnp.fitcoach.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.idnp.fitcoach.MonthStatsGraphicFragment;
import com.idnp.fitcoach.WeekStatsGraphicFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int numTabss) {
        super(fm);
        this.numTabs = numTabss;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new WeekStatsGraphicFragment();
            case 1:
                return new MonthStatsGraphicFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
