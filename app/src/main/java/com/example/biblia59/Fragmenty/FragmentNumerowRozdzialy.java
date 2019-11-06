package com.example.biblia59.Fragmenty;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.biblia59.Adaptery.AdapterRecyclerNumerowRozdzialy;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceRozdzialy;
import com.example.biblia59.R;
import com.example.biblia59.Rozne.ListaKsiag;
public class FragmentNumerowRozdzialy extends Fragment implements SluchaczKliknietegoElementuInterfaceRozdzialy
    {
        private static final String nrKsiegi = "kluczStart";
        private static final String kluczNaglowek = "kluczNaglowek";

        private int mNumerKsiegi;
        String mNaglowek;

        private SluchaczKliknietegoElementuInterfaceRozdzialy listenerMain;

        public static FragmentNumerowRozdzialy newInstance(int numerKsiegi,String naglowekk)
            {
                FragmentNumerowRozdzialy fragmentNumerowRozdzialy = new FragmentNumerowRozdzialy();
                Bundle args = new Bundle();
                args.putInt(nrKsiegi, numerKsiegi);
                args.putString(kluczNaglowek,naglowekk);
                fragmentNumerowRozdzialy.setArguments(args);
                return fragmentNumerowRozdzialy;
            }

        @SuppressLint("SetTextI18n") @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
            {
                View view = inflater.inflate(R.layout.fragment_lista_rozdzialow, container, false);

                if (getArguments() != null) {
                    mNumerKsiegi = (int) getArguments().get(nrKsiegi);
                    mNaglowek = (String) getArguments().get(kluczNaglowek);

                }

                ListaKsiag listaKsiag = new ListaKsiag();
                RecyclerView recyclerView = view.findViewById(R.id.id_recycler_rozdzialow);
                recyclerView.setHasFixedSize(true);
                AdapterRecyclerNumerowRozdzialy adapterRecyclerNumerowRozdzialy = new AdapterRecyclerNumerowRozdzialy(listaKsiag.getStaryNowyTestament().get(mNumerKsiegi).getIloscKsiag());
                recyclerView.setAdapter(adapterRecyclerNumerowRozdzialy);
                adapterRecyclerNumerowRozdzialy.ustawSluczhaczakliknietegoRoz(this);

                if (listenerMain != null) {
                    listenerMain.przekaz_naglowek_z_FragmentuRozdzialy(mNaglowek);

                }
                return view;
            }


        @Override public void onAttach(Context context)
            {
                super.onAttach(context);
                if (context instanceof SluchaczKliknietegoElementuInterfaceRozdzialy) {

                    listenerMain = (SluchaczKliknietegoElementuInterfaceRozdzialy) context;
                }
                else {
                    throw new RuntimeException(context.toString() + "musisz cos dodac");
                }
            }
        @Override public void klik_na_rozdzial(int Nr_rozdzialu)
            {
                listenerMain.klik_na_rozdzial(Nr_rozdzialu);
            }
        @Override public void przekaz_naglowek_z_FragmentuRozdzialy(String Naglowek)
            {
                listenerMain.przekaz_naglowek_z_FragmentuRozdzialy(Naglowek);
            }


    }
