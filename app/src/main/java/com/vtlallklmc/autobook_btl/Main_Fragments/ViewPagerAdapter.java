package com.vtlallklmc.autobook_btl.Main_Fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new NewCarFragment();
            case 1: return new BestSelledFragment();
            case 2: return new BrandFragment();
//            case 3: return new PersonalFragment()
            default: return new NewCarFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
