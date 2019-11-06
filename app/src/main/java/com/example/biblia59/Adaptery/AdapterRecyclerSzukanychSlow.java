package com.example.biblia59.Adaptery;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.biblia59.R;
import com.example.biblia59.Rozne.Model_danych_szukaj_slowa;

import java.util.List;

public class AdapterRecyclerSzukanychSlow extends RecyclerView.Adapter<AdapterRecyclerSzukanychSlow.ViewHolder> {
    private List<Model_danych_szukaj_slowa> lista_wersetow_z_szukanym_slowem;

    public AdapterRecyclerSzukanychSlow(List<Model_danych_szukaj_slowa> wyniki_szukania_slowa) {
        this.lista_wersetow_z_szukanym_slowem=wyniki_szukania_slowa;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wyglad_wiersza_szukane_slowa,parent,false);
        return new AdapterRecyclerSzukanychSlow.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        viewHolder.Tv_Ksiegi.setText(Html.fromHtml(lista_wersetow_z_szukanym_slowem.get(i).getNazwa_ksiegi_numer_rozdzialu()));
        viewHolder.Tv_wersy.setText(Html.fromHtml(lista_wersetow_z_szukanym_slowem.get(i).getNumer_wersu_tresc_wersu()));

    }

    @Override
    public int getItemCount() {
        return lista_wersetow_z_szukanym_slowem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
     TextView Tv_Ksiegi,Tv_wersy;
        ViewHolder(View itemView) {
            super(itemView);
            Tv_Ksiegi = itemView.findViewById(R.id.szukaj_ksiega);
            Tv_wersy = itemView.findViewById(R.id.szukaj_rozdzial_wers);
        }
    }
}
