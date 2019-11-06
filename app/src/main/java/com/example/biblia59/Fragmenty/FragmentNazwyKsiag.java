package com.example.biblia59.Fragmenty;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia59.Adaptery.AdapterRecyclerNazwKsiag;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceKsiegi;
import com.example.biblia59.R;
import com.example.biblia59.Rozne.ListaKsiag;

import java.util.Objects;
public class FragmentNazwyKsiag extends Fragment implements SluchaczKliknietegoElementuInterfaceKsiegi
    {
        private SluchaczKliknietegoElementuInterfaceKsiegi mListener;

        private static final String kluczStart = "kluczStart";
        private static final String kluczKoniec = "kluczKoniec";
        private static final String kluczNaglowek = "kluczNaglowek";
        public static FragmentNazwyKsiag newInstance(int start, int koniec, String naglowek)
            {
                FragmentNazwyKsiag fragment = new FragmentNazwyKsiag();
                Bundle args = new Bundle();
                args.putInt(kluczStart, start);
                args.putInt(kluczKoniec,koniec);
                args.putString(kluczNaglowek,naglowek);

                fragment.setArguments(args);
                return fragment;
            }
        @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
            {
                View view = inflater.inflate(R.layout.fragment_nazwy_ksiag, container, false);


                ListaKsiag listaKsiag = new ListaKsiag();

                if (getArguments() != null) {
                    int mStart = (int) getArguments().get(kluczStart);
                    int mKoniec = (int) getArguments().get(kluczKoniec);
                    String mNaglowek = (String) getArguments().get(kluczNaglowek);

                    RecyclerView recyclerView = view.findViewById(R.id.id_listaRecyclerview);
                    recyclerView.setHasFixedSize(true);
                    @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(layoutManager);
                    AdapterRecyclerNazwKsiag adapter =new AdapterRecyclerNazwKsiag(listaKsiag.getStaryNowyTestament().subList(mStart, mKoniec));
                    adapter.UstawSluczaczaKlikniecia(this);
                    recyclerView.setAdapter(adapter);
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL);
                    dividerItemDecoration.setDrawable(this.getResources().getDrawable(R.drawable.item_decorator));
                    recyclerView.addItemDecoration(dividerItemDecoration);

                    if (mListener != null) {
                        mListener.przekaz_naglowek_z_fragmentKsiegi(mNaglowek);}


                }
                return view;
            }
        @Override public void onAttach(@NonNull Context context)
            {
                super.onAttach(context);
                if(context instanceof SluchaczKliknietegoElementuInterfaceKsiegi)
                {
                    mListener = (SluchaczKliknietegoElementuInterfaceKsiegi) context;
                }
                else
                {
                    throw new RuntimeException(context.toString()+" musisz implementowac");
                }


            }
        @Override public void klik_na_ksiega(String Ksiega)
            {
                mListener.klik_na_ksiega(Ksiega);
            }
        @Override public void przekaz_naglowek_z_fragmentKsiegi(String Naglowek)
            {
                mListener.przekaz_naglowek_z_fragmentKsiegi(Naglowek);
            }
        @Override public void klik_na_komentarz(String Ksiega)
            {
                mListener.klik_na_komentarz(Ksiega);

            }
    }
