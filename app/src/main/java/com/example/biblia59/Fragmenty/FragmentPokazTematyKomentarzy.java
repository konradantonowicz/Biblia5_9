package com.example.biblia59.Fragmenty;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biblia59.Adaptery.AdapterRecyclerTematowKomentarzy;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceNazwaTematu;
import com.example.biblia59.R;
import com.example.biblia59.Rozne.BazaDanych_Biblia;

import java.util.Objects;
/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPokazTematyKomentarzy extends Fragment implements SluchaczKliknietegoElementuInterfaceNazwaTematu
    {
        private SluchaczKliknietegoElementuInterfaceNazwaTematu mListener;
        private static final String kluczKsiega = "kluczKsiega";
        public static FragmentPokazTematyKomentarzy newInstance(String ksiega)
            {
                FragmentPokazTematyKomentarzy pokazTematy = new FragmentPokazTematyKomentarzy();
                Bundle args = new Bundle();
                args.putString(kluczKsiega,ksiega);
                pokazTematy.setArguments(args);

                return pokazTematy;
            }
        @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
            {
                BazaDanych_Biblia bazaDanych_biblia = new BazaDanych_Biblia(getContext());
                View view = inflater.inflate(R.layout.fragment_pokaz_tematy, container, false);

                if (getArguments() != null)
                {


                    String mKsiega = (String) getArguments().get(kluczKsiega);


                    RecyclerView recyclerView = view.findViewById(R.id.id_listaTematowRecyclerview);
                   recyclerView.setHasFixedSize(true);
                    @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                   recyclerView.setLayoutManager(layoutManager);
                    AdapterRecyclerTematowKomentarzy adapter =new AdapterRecyclerTematowKomentarzy(bazaDanych_biblia.PokazTematyKomentarzy(Integer.parseInt(Objects.requireNonNull(mKsiega))-1),mKsiega);
                    AdapterRecyclerTematowKomentarzy.UstawSluczaczaKliknieciaRozneTematy(this);
                   recyclerView.setAdapter(adapter);
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL);
                    dividerItemDecoration.setDrawable(this.getResources().getDrawable(R.drawable.item_decorator));
                    recyclerView.addItemDecoration(dividerItemDecoration);



                    if (mListener != null) {
                        mListener.przekazNaglowekZFragmentuTematyKomentarzy(mKsiega);
                    }




                }

                return view;
            }

        @Override public void klikNaTematKomentarza(String numer_ksiegi, String numer_tematu, Integer liczbaTematow)
            {
        mListener.klikNaTematKomentarza(numer_ksiegi,  numer_tematu,  liczbaTematow);
            }
        @Override public void przekazNaglowekZFragmentuTematyKomentarzy(String Naglowek)
            {
                mListener.przekazNaglowekZFragmentuTematyKomentarzy(Naglowek);
            }
        @Override public void onAttach(@NonNull Context context)
            {
                super.onAttach(context);
                if(context instanceof SluchaczKliknietegoElementuInterfaceNazwaTematu)
                {
                    mListener = (SluchaczKliknietegoElementuInterfaceNazwaTematu) context;
                }
                else
                {
                    throw new RuntimeException(context.toString()+" musisz implementowac");
                }


            }

    }
