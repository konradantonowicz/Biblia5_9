package com.example.biblia59.Adaptery;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia59.Fragmenty.FragmentPokazTematyKomentarzy;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceNazwaTematu;
import com.example.biblia59.R;

import java.util.List;
public class AdapterRecyclerTematowKomentarzy extends RecyclerView.Adapter<AdapterRecyclerTematowKomentarzy.ViewHolder>{


    private static SluchaczKliknietegoElementuInterfaceNazwaTematu sluchaczKliknietegoElementuInterfaceTematy;
    private List<String> mListaTematow;
    private String mnumer_ksiegi;

    public AdapterRecyclerTematowKomentarzy(List<String> ListaTematow, String numer_ksiegi) {
        this.mListaTematow=ListaTematow;
        this.mnumer_ksiegi=numer_ksiegi;
    }

    public static void UstawSluczaczaKliknieciaRozneTematy(FragmentPokazTematyKomentarzy fragmentPokazTematy) {
        sluchaczKliknietegoElementuInterfaceTematy=fragmentPokazTematy;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wyglad_wiersza_tematy_komentarzy, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.itemTv.setText(mListaTematow.get(position));
    }


    @Override
    public int getItemCount() {
        return mListaTematow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTv=itemView.findViewById(R.id.wiersz_nazwa_tematu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sluchaczKliknietegoElementuInterfaceTematy.klikNaTematKomentarza(mnumer_ksiegi, String.valueOf(ViewHolder.this.getAdapterPosition()),mListaTematow.size());
                }
            });

        }
    }


}
