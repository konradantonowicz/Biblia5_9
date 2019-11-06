package com.example.biblia59;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
public class ViewModel_ViewPager extends ViewModel
    {
        private MutableLiveData<List<Fragment>> mojaListaFragmentow;
        MutableLiveData<List<Fragment>> pierwszyRazZrob(List<Fragment> fragments)
            {
                if (mojaListaFragmentow == null) {
                    mojaListaFragmentow = new MutableLiveData<>();
                    mojaListaFragmentow.setValue(fragments);
                }
                return mojaListaFragmentow;
            }
        public void drugiRazZrob(List<Fragment> Naglowek)
            {
                mojaListaFragmentow.setValue(Naglowek);
            }
        public MutableLiveData<List<Fragment>> wezNaglowek()
            {
                return mojaListaFragmentow;
            }
    }




