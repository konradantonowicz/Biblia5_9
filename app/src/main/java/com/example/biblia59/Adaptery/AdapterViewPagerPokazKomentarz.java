package com.example.biblia59.Adaptery;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;
public class AdapterViewPagerPokazKomentarz extends FragmentPagerAdapter
    {
        private List<Fragment> fragments;
        public AdapterViewPagerPokazKomentarz(FragmentManager supportFragmentManager, List<Fragment> fragments)
            {
                super(supportFragmentManager);
                this.fragments = fragments;
            }

        @Override
        public Fragment getItem(int position)
            {
                return fragments.get(position);
            }

        @Override
        public int getCount()
            {
                return fragments.size();
            }
    }
