package com.example.biblia59.Adaptery;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.biblia59.Fragmenty.FragmentPokazWersety;

import java.util.List;
public class AdapterViewPagerPokazWersety extends FragmentStatePagerAdapter
    {


        String mKsiega,mNaglowek;
        int mLiczbaStr;


        public AdapterViewPagerPokazWersety(FragmentManager supportFragmentManager, String ksiega, String naglowek, int liczbaStr)
            {
                super(supportFragmentManager);
                this.mKsiega=ksiega;
                this.mNaglowek=naglowek;
                this.mLiczbaStr=liczbaStr;
            }
        @NonNull @Override public Fragment getItem(int position)
            {
                return FragmentPokazWersety.newInstance(mKsiega,position+1,mNaglowek);
            }
        @Override public int getCount()
            {

                return mLiczbaStr;
            }







    }