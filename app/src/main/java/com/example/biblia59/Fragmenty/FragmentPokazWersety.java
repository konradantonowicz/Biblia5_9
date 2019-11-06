package com.example.biblia59.Fragmenty;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia59.Adaptery.AdapterRecyclerPokazWersety;
import com.example.biblia59.AktywnoscPokazPrzypisy;
import com.example.biblia59.AktywnoscPokazStronga;
import com.example.biblia59.Interface.SluchaczNaglowkaFragmentuPokazWersety;
import com.example.biblia59.R;
import com.example.biblia59.Rozne.BazaDanych_Biblia;
public class FragmentPokazWersety extends Fragment
    {
        private static final String mNrKsiegiklucz = "kluczKsiega";
        private static final String mNrRozdzialuklucz = "kluczRozdzial";
        private static final String kluczNaglowek = "kluczNaglowek";
        private String mNrKsiegi;
        private int mNrRozdzialu;
        private String mNaglowek;
        private SluchaczNaglowkaFragmentuPokazWersety listener;
        public static FragmentPokazWersety newInstance(String nrKsiegi, int nrRozdzial, String naglowekk)
            {
                FragmentPokazWersety fragmentPokazWersety = new FragmentPokazWersety();
                Bundle args = new Bundle();
                args.putString(mNrKsiegiklucz, nrKsiegi);
                args.putInt(mNrRozdzialuklucz, nrRozdzial);
                args.putString(kluczNaglowek, naglowekk);
                fragmentPokazWersety.setArguments(args);
                return fragmentPokazWersety;
            }
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
            {
                BazaDanych_Biblia mBazaDanych = new BazaDanych_Biblia(getContext());
                View rootView = inflater.inflate(R.layout.fragment_pokaz_wersety, container, false);
                if (getArguments() != null) {
                    mNrKsiegi = (String) getArguments().get(mNrKsiegiklucz);
                    mNrRozdzialu = (int) getArguments().get(mNrRozdzialuklucz);
                    mNaglowek = (String) getArguments().get(kluczNaglowek);
                }
                if (listener != null) {
                    listener.przekazNaglowek_z_Wersetow(mNaglowek);
                }
                RecyclerView recyclerView = rootView.findViewById(R.id.wersy_recycler);
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                AdapterRecyclerPokazWersety adapter_recyclera_wersety = new AdapterRecyclerPokazWersety(getActivity(), mBazaDanych.PokazWersetyBibli(mNrKsiegi, String.valueOf(mNrRozdzialu)));
                recyclerView.setAdapter(adapter_recyclera_wersety);
                return rootView;
            }


        @Override
        public boolean onContextItemSelected(MenuItem item) {

            switch (item.getTitle().toString())
            {
                case "Pokaż Przypis":

                {


                    Intent intent_pokaz_odnosniki = new Intent(getContext(), AktywnoscPokazPrzypisy.class);
                    intent_pokaz_odnosniki.putExtra("NumerKsiegi", mNrKsiegi);
                    intent_pokaz_odnosniki.putExtra("NumerRozdzialu", String.valueOf(mNrRozdzialu));
                    intent_pokaz_odnosniki.putExtra("NumerWersetu", String.valueOf(item.getGroupId()));
                    startActivity(intent_pokaz_odnosniki);


                }break;
                case "Numery Stronga":
                {

                    Intent intent_pokaz_stronga = new Intent(getContext(), AktywnoscPokazStronga.class);
                    intent_pokaz_stronga.putExtra("NumerKsiegi", mNrKsiegi);
                    intent_pokaz_stronga.putExtra("NumerRozdzialu", String.valueOf(mNrRozdzialu));
                    intent_pokaz_stronga.putExtra("NumerWersetu", String.valueOf(item.getGroupId()));
                    startActivity(intent_pokaz_stronga);



                }break;





                default:  return super.onContextItemSelected(item);

            }

            return true;

        }




        @Override public void onAttach(@NonNull Context context)
            {
                super.onAttach(context);
                if (context instanceof SluchaczNaglowkaFragmentuPokazWersety) {
                    listener = (SluchaczNaglowkaFragmentuPokazWersety) context;
                }
                else {
                    throw new RuntimeException(context.toString() + " musisz implementowac");
                }
            }
    }
