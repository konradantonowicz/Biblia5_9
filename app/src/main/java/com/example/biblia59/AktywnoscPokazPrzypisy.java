package com.example.biblia59;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.biblia59.Adaptery.AdapterRecyclerSzukanychSlow;
import com.example.biblia59.Rozne.BazaDanych_Biblia;
public class AktywnoscPokazPrzypisy extends AppCompatActivity
    {
        @Override protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.aktywnosc_pokaz_przypisy);


                BazaDanych_Biblia bibliaKomentarze = new BazaDanych_Biblia(this);

                Intent intent = getIntent();

                String ksiega = intent.getStringExtra("NumerKsiegi");
                String rozdzial = intent.getStringExtra("NumerRozdzialu");
                String werset = intent.getStringExtra("NumerWersetu");

                System.out.println(ksiega+"/"+rozdzial+"/"+werset);
                RecyclerView recyclerView = findViewById(R.id.id_recycler_DialogBox);
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
                AdapterRecyclerSzukanychSlow adapter_recyclera_szukaj = new AdapterRecyclerSzukanychSlow(bibliaKomentarze.PokazOdnosniki(ksiega, rozdzial, werset));
                recyclerView.setAdapter(adapter_recyclera_szukaj);
            }
    }
