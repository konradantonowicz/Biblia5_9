package com.example.biblia59;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.biblia59.Adaptery.AdapterViewPagerPokazKomentarz;
import com.example.biblia59.Fragmenty.FragmentPokazKomentarzeRozne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class AktywnoscPokazKomentarz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aktywnosc_pokaz_komentarz);


        Intent intent          = getIntent();
        int numer_tematu    = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra("numer_tematu")));
        int iloscc    = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra("ilosctematow")));
        String         ksiega          = intent.getStringExtra("ksiega");

System.out.println(ksiega+"/"+numer_tematu+"/"+iloscc);

        List<Fragment> fragments       = new ArrayList<>();


        for (int x=0;x<iloscc;x++)       {
            fragments.add(FragmentPokazKomentarzeRozne.newInstance(ksiega+x));

        }

        ViewPager vp      = findViewById(R.id.viewpager);
       AdapterViewPagerPokazKomentarz adapter = new AdapterViewPagerPokazKomentarz(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);
        vp.setCurrentItem(numer_tematu);

    }
}