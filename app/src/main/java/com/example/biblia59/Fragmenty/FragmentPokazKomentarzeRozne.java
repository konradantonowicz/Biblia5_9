package com.example.biblia59.Fragmenty;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia59.Adaptery.AdapterRecyclerPokazKomentarz_4_pola;
import com.example.biblia59.R;
import com.example.biblia59.Rozne.BazaDanych_Biblia;

import java.util.Objects;


public class FragmentPokazKomentarzeRozne extends Fragment
{

private static final String Arg_text = "arg_text";
    String numerek = null;
    public static FragmentPokazKomentarzeRozne newInstance (String ksiega)
    {

        FragmentPokazKomentarzeRozne fragment_PokazKomentarze = new FragmentPokazKomentarzeRozne();

        Bundle args = new Bundle();

        args.putString(Arg_text,ksiega);

        fragment_PokazKomentarze.setArguments(args);

        return fragment_PokazKomentarze;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
                View rootView = inflater.inflate(R.layout.fragment_pokaz_komentarze, container, false);

        BazaDanych_Biblia bibliaKomentarze = new BazaDanych_Biblia(getContext());

        if (getArguments()!=null)
        {
          numerek = (String) getArguments().get(Arg_text);

        }

        RecyclerView recyclerView_komentarz = rootView.findViewById(R.id.recyler_komentarz);
        recyclerView_komentarz.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView_komentarz.setLayoutManager(layoutManager);
        AdapterRecyclerPokazKomentarz_4_pola adapter_recyclera_komentarz = new AdapterRecyclerPokazKomentarz_4_pola(Objects.requireNonNull(getActivity()),bibliaKomentarze.LadujKomentarzeDoFragmentu_4_pola(numerek));
        recyclerView_komentarz.setAdapter(adapter_recyclera_komentarz);


        return rootView;
    }

}
