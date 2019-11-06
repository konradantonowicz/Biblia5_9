package com.example.biblia59;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.biblia59.Adaptery.AdapterViewPagerPokazWersety;
import com.example.biblia59.Interface.SluchaczNaglowkaFragmentuPokazWersety;
import com.example.biblia59.Rozne.ListaKsiag;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;
public class AktywnoscPokazWersety extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SluchaczNaglowkaFragmentuPokazWersety
    {
        String nag;
        String ksiega;
        int rozdzial,liczbaStr;
        String naglowek;
        @Override protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.aktywnosc_pokaz_wersety);
                stworzNawigacje();
                ListaKsiag listaKsiag = new ListaKsiag();
                 ksiega = getIntent().getStringExtra("numerKsiegi");
                rozdzial = Integer.parseInt(Objects.requireNonNull(getIntent().getStringExtra("numerRozdzialu")));
              naglowek = getIntent().getStringExtra("nazwaNaglowek");
               liczbaStr = Integer.parseInt(listaKsiag.getStaryNowyTestament().get(Integer.parseInt(Objects.requireNonNull(ksiega)) - 1).getIloscKsiag());
                ViewPager vp = findViewById(R.id.viewpager);
                AdapterViewPagerPokazWersety adapter = new AdapterViewPagerPokazWersety(getSupportFragmentManager(), ksiega, naglowek, liczbaStr);
                vp.setAdapter(adapter);
                vp.setCurrentItem(rozdzial - 1);
                vp.setOffscreenPageLimit(2);
                vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
                    {
                        @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
                            {
                                int pozycja = position + 1;
                                Objects.requireNonNull(getSupportActionBar()).setTitle(nag + " " + pozycja);
                            }
                        @Override public void onPageSelected(int position)
                            {
                            }
                        @Override public void onPageScrollStateChanged(int state)
                            {
                            }
                    });
            }
        private void stworzNawigacje()
            {
                Toolbar toolbar = findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                final DrawerLayout drawer = findViewById(R.id.drawer_layout);
                final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                drawer.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable
                toggle.setHomeAsUpIndicator(R.drawable.ic_biale_menu48x48);
                toggle.setToolbarNavigationClickListener(new View.OnClickListener()
                    {
                        @SuppressLint("RtlHardcoded") @Override public void onClick(View view)
                            {
                                drawer.openDrawer(Gravity.LEFT);
                            }
                    });
                toggle.syncState();
                NavigationView navigationView = findViewById(R.id.nav_view_pokaz_wersety);
                navigationView.setNavigationItemSelectedListener(this);
            }
        @Override public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                Intent intent = new Intent();
                int id = menuItem.getItemId();
                if (id == R.id.id_nav_stary_testament) {
                    intent.putExtra("MESSAGE", "stary");
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                else if (id == R.id.id_nav_nowy_testament) {
                    intent.putExtra("MESSAGE", "nowy");
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                else if (id == R.id.id_nav_stary_nowy_testament) {
                    intent.putExtra("MESSAGE", "starynowy");
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                else if (id == R.id.id_nav_komentarze) {
                    intent.putExtra("MESSAGE", "komentarze");
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                else if (id == R.id.id_nav_szukaj) {
                    Intent aktywnoscSzukajSlowa = new Intent(this,AktywnoscSzukanieSlow.class);
                    startActivity(aktywnoscSzukajSlowa);
                }
                else if (id == R.id.id_nav_ustawienia)
                {
                    Intent aktywnoscUstawienia = new Intent(this,AktywnoscUstawienia.class);
                    startActivity(aktywnoscUstawienia);
                }
                else if (id == R.id.id_nav_komentarze_rozne) {
                    intent.putExtra("MESSAGE", "komentarzerozne");
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        @Override public void przekazNaglowek_z_Wersetow(String naglowek)
            {
                nag = naglowek;
            }

    }
