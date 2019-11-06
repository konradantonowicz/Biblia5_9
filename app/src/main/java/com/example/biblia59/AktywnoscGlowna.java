package com.example.biblia59;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.biblia59.Fragmenty.FragmentNumerowRozdzialy;
import com.example.biblia59.Fragmenty.FragmentPokazTematyKomentarzy;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceKsiegi;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceNazwaTematu;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceRozdzialy;
import com.example.biblia59.Rozne.BazaDanych_Biblia;
import com.example.biblia59.Rozne.ListaKsiag;
import com.example.biblia59.Rozne.Obsluga_Bazy_Danych_TablicaFTS3;
import com.google.android.material.navigation.NavigationView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.biblia59.Fragmenty.FragmentNazwyKsiag.newInstance;
public class AktywnoscGlowna extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SluchaczKliknietegoElementuInterfaceKsiegi, SluchaczKliknietegoElementuInterfaceRozdzialy, SluchaczKliknietegoElementuInterfaceNazwaTematu, Handler.Callback
    {
        ViewModel_ViewPager model;
        MutableLiveData<List<Fragment>> dane_viewPager;
        ListaKsiag listaKsiag;
        FragmentManager manager;
        ArrayList<Fragment> listaFragmentow;
        BazaDanych_Biblia bazaDanych;
        Obsluga_Bazy_Danych_TablicaFTS3 slownik_fts3;
        TextView tvProgres;
        int dlugosc;
        int count = 0;
        Fragment[] GrupyKsiag;
        private boolean twice;
        @Override protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.aktywnosc_glowna);
                stworzNawigacje();
                stworzGrupyKsiag();
                bazaDanych = new BazaDanych_Biblia(this);
                slownik_fts3 = new Obsluga_Bazy_Danych_TablicaFTS3(this);
                HandlerThread thread = new HandlerThread("Licznik", Process.THREAD_PRIORITY_BACKGROUND);
                thread.start();
                Handler handler = new Handler(thread.getLooper(), this);
                handler.sendEmptyMessage(0);
                listaFragmentow = new ArrayList<>();
                listaFragmentow.add(0,GrupyKsiag[2]);
                listaFragmentow.add(GrupyKsiag[3]);
                manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.id_fragment, GrupyKsiag[2]);
                transaction.commit();
                stworzViewModel();
                listaKsiag = new ListaKsiag();
                tvProgres = findViewById(R.id.id_tv_progress);
                dlugosc = 11567104 + 9244672;
            }
        @Override public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int id = menuItem.getItemId();
                if (id == R.id.id_nav_stary_testament) {
                    listaFragmentow.set(0, GrupyKsiag[0]);
                }
                else if (id == R.id.id_nav_nowy_testament) {
                    listaFragmentow.set(0, GrupyKsiag[1]);
                }
                else if (id == R.id.id_nav_stary_nowy_testament) {
                    listaFragmentow.set(0, GrupyKsiag[2]);
                }
                else if (id == R.id.id_nav_komentarze) {
                    listaFragmentow.set(0, GrupyKsiag[3]);
                }
                else if (id == R.id.id_nav_komentarze_rozne) {
                    listaFragmentow.set(0, GrupyKsiag[4]);
                }
                else if (id == R.id.id_nav_szukaj) {
                    Intent aktywnoscSzukajSlowa = new Intent(this, AktywnoscSzukanieSlow.class);
                    startActivity(aktywnoscSzukajSlowa);
                }
                else if (id == R.id.id_nav_ustawienia) {
                    Intent aktywnoscUstawienia = new Intent(this, AktywnoscUstawienia.class);
                    startActivity(aktywnoscUstawienia);
                }
                model.drugiRazZrob(listaFragmentow);
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        @Override public void klik_na_ksiega(String Ksiega)
            {
                int id_ksiegi_int = Integer.parseInt(listaKsiag.ZamienNazweKsiegiNaNumerKsiegi(Ksiega));
                String id_ksiegi_str = listaKsiag.ZamienNazweKsiegiNaNumerKsiegi(Ksiega);
                if (id_ksiegi_int > 699) {
                    Intent pokazkomentarze = new Intent(this, AktywnoscPokazKomentarz.class);
                    pokazkomentarze.putExtra("numer_tematu", id_ksiegi_str.substring(2));
                    pokazkomentarze.putExtra("ksiega", id_ksiegi_str.substring(0, 2));
                    pokazkomentarze.putExtra("ilosctematow", "8");

                    System.out.println(id_ksiegi_str.substring(0,2));

                    startActivity(pokazkomentarze);
                }
                else {

                    listaFragmentow.set(1, listaFragmentow.get(0));
                   listaFragmentow.set(0, FragmentNumerowRozdzialy.newInstance(id_ksiegi_int - 1, Ksiega));
                    model.drugiRazZrob(listaFragmentow);
                }
            }
        @Override public void klik_na_rozdzial(int Nr_rozdzialu)
            {
                int numerKsiegi = Integer.parseInt(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(dane_viewPager.getValue()).get(0).getArguments()).get("kluczStart")).toString());
                Intent aktywnoscPokazWersety = new Intent(this, AktywnoscPokazWersety.class);
                aktywnoscPokazWersety.putExtra("numerKsiegi", String.valueOf(numerKsiegi + 1));
                aktywnoscPokazWersety.putExtra("numerRozdzialu", String.valueOf(Nr_rozdzialu + 1));
                aktywnoscPokazWersety.putExtra("nazwaNaglowek", Objects.requireNonNull(Objects.requireNonNull(dane_viewPager.getValue().get(0).getArguments()).get("kluczNaglowek")).toString());
                startActivityForResult(aktywnoscPokazWersety, 1);
            }
        @Override public void przekaz_naglowek_z_fragmentKsiegi(String Naglowek)
            {
                Objects.requireNonNull(getSupportActionBar()).setTitle(Naglowek);
            }
        @Override public void klik_na_komentarz(String Ksiega)
            {
                listaFragmentow.set(1, listaFragmentow.get(0));
                String id_ksiegi_str = listaKsiag.ZamienNazweKsiegiNaNumerKsiegi(Ksiega);
                FragmentPokazTematyKomentarzy fragmentPokazTematy = FragmentPokazTematyKomentarzy.newInstance(id_ksiegi_str);
                listaFragmentow.set(0, fragmentPokazTematy);
                model.drugiRazZrob(listaFragmentow);


            }
        @Override public void przekaz_naglowek_z_FragmentuRozdzialy(String Naglowek)
            {
                Objects.requireNonNull(getSupportActionBar()).setTitle(Naglowek);
            }
        @Override public void onBackPressed()
            {
                Toast.makeText(getApplicationContext(), "Ponowne Kliknięcie powoduje WYJŚCIE", Toast.LENGTH_SHORT).show();
                listaFragmentow.set(0, Objects.requireNonNull(dane_viewPager.getValue()).get(1));
                model.drugiRazZrob(listaFragmentow);
                if (twice) {
                    finish();
                    System.exit(0);
                }
                twice = true;
                new Handler().postDelayed(new Runnable()
                    {
                        @Override public void run()
                            {
                                twice = false;
                            }
                    }, 2000);
            }
        @Override protected void onActivityResult(int requestCode, int resultCode, Intent data)
            {
                super.onActivityResult(requestCode, resultCode, data);
                if (resultCode == RESULT_OK) {
                    String message = data.getStringExtra("MESSAGE");
                    if (message == null) {
                        message = "starynowy";
                    }
                    switch (message) {
                        case "stary":
                            listaFragmentow.set(0, GrupyKsiag[0]);
                            model.drugiRazZrob(listaFragmentow);
                            break;
                        case "nowy":
                            listaFragmentow.set(0, GrupyKsiag[1]);
                            model.drugiRazZrob(listaFragmentow);
                            break;
                        case "starynowy":
                            listaFragmentow.set(0, GrupyKsiag[2]);
                            model.drugiRazZrob(listaFragmentow);
                            break;
                        case "komentarze":
                            listaFragmentow.set(0, GrupyKsiag[3]);
                            model.drugiRazZrob(listaFragmentow);
                            break;
                        case "komentarzerozne":
                            listaFragmentow.set(0, GrupyKsiag[4]);
                            model.drugiRazZrob(listaFragmentow);
                            break;
                    }
                }
            }
        @Override public void klikNaTematKomentarza(String numer_ksiegi, String numer_tematu, Integer liczbaTematow)
            {
                Intent pokazkomentarze = new Intent(this, AktywnoscPokazKomentarz.class);
                pokazkomentarze.putExtra("numer_tematu", numer_tematu);
                pokazkomentarze.putExtra("ksiega", numer_ksiegi);
                pokazkomentarze.putExtra("ilosctematow", String.valueOf(liczbaTematow));
                startActivity(pokazkomentarze);

                //System.out.println(String.valueOf(liczbaTematow));


            }
        @Override public void przekazNaglowekZFragmentuTematyKomentarzy(String Naglowek)
            {
                int id_ksiegi_int = Integer.parseInt(Naglowek);
                Objects.requireNonNull(getSupportActionBar()).setTitle(listaKsiag.getStaryNowyTestament().get(id_ksiegi_int - 1).getNazwaKsiegi());
            }
        @Override public boolean handleMessage(@NonNull Message message)
            {
                kopiowanieBazyDanychBiblia();
                kopiowanieBazyDanychBibliaSlownik();
                return false;
            }
        private void kopiowanieBazyDanychBiblia()
            {
                Obsluga_Bazy_Danych_TablicaFTS3 baza = new Obsluga_Bazy_Danych_TablicaFTS3(this);
                File database = getApplicationContext().getDatabasePath(Obsluga_Bazy_Danych_TablicaFTS3.DBNAME);
                if (!database.exists()) {
                    baza.getReadableDatabase();
                    baza.close();
                    int progress;
                    try {
                        InputStream inputStreamm = getApplicationContext().getAssets().open(Obsluga_Bazy_Danych_TablicaFTS3.DBNAME);
                        System.out.println("BazaDanych Biblia=" + inputStreamm.available());
                        String outFileName = Obsluga_Bazy_Danych_TablicaFTS3.DBLOCATION + Obsluga_Bazy_Danych_TablicaFTS3.DBNAME;
                        OutputStream outputStreamm = new FileOutputStream(outFileName);
                        byte[] bufff = new byte[1024];
                        int lengthh;
                        while ((lengthh = inputStreamm.read(bufff)) > 0) {
                            outputStreamm.write(bufff, 0, lengthh);
                            count += lengthh;
                            progress = count * 100 / dlugosc;
                            runOnUiThread(new ProgressBarTextView(tvProgres, String.valueOf(progress)));
                        }
                        outputStreamm.flush();
                        outputStreamm.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {
                    runOnUiThread(new toast());
                }
            }
        private void kopiowanieBazyDanychBibliaSlownik()
            {
                File database = getApplicationContext().getDatabasePath(BazaDanych_Biblia.DBNAME);
                if (!database.exists()) {
                    bazaDanych.getReadableDatabase();
                    bazaDanych.close();
                    int progress;
                    try {
                        InputStream inputStream = getApplicationContext().getAssets().open(BazaDanych_Biblia.DBNAME);
                        System.out.println("Słownik Biblia=" + inputStream.available());
                        String outFileName = BazaDanych_Biblia.DBLOCATION + BazaDanych_Biblia.DBNAME;
                        OutputStream outputStream = new FileOutputStream(outFileName);
                        byte[] buff = new byte[1024];
                        int length;
                        while ((length = inputStream.read(buff)) > 0) {
                            outputStream.write(buff, 0, length);
                            count += length;
                            progress = count * 100 / dlugosc;
                            runOnUiThread(new ProgressBarTextView(tvProgres, String.valueOf(progress)));
                        }
                        outputStream.flush();
                        outputStream.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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
                NavigationView navigationView = findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(this);
            }
        private void stworzViewModel()
            {
                model = ViewModelProviders.of(this).get(ViewModel_ViewPager.class);
                dane_viewPager = model.pierwszyRazZrob(listaFragmentow);
                dane_viewPager.observe(this, new Observer<List<Fragment>>()
                    {
                        @Override public void onChanged(List<Fragment> fragmentt)
                            {
                                manager = getSupportFragmentManager();
                                FragmentTransaction transaction = manager.beginTransaction();
                                transaction.replace(R.id.id_fragment, fragmentt.get(0));
                                transaction.addToBackStack(null).commit();
                            }
                    });
            }
        private void stworzGrupyKsiag()
            {
                GrupyKsiag = new Fragment[]{newInstance(0, 39, "Stary Testament"), newInstance(39, 66, "Nowy Testament"), newInstance(0, 66, "Stary i Nowy Testament"), newInstance(66, 72, "Komentarze"), newInstance(72, 80, "Komentarze Różne")
                };
            }
        class ProgressBarTextView implements Runnable
            {
                private TextView t;
                private String liczba;
                ProgressBarTextView(TextView t, String liczba)
                    {
                        this.t = t;
                        this.liczba = liczba;
                    }
                @SuppressLint("SetTextI18n") @Override public void run()
                    {
                        t.setText("Ładowanie" + "\t\t\t" + liczba + "%");
                        if (liczba.equals("100")) {
                            t.postDelayed(new Runnable()
                                {
                                    public void run()
                                        {
                                            t.setVisibility(View.GONE);
                                        }
                                }, 5000);
                        }
                    }
            }
        class toast implements Runnable
            {
                @Override public void run()
                    {
                        Toast.makeText(getApplicationContext(), "Baza danych załadowana Pomyślnie", Toast.LENGTH_SHORT).show();
                    }
            }
    }

