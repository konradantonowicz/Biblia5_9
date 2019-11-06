package com.example.biblia59.Adaptery;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia59.R;
import com.example.biblia59.Rozne.Model_danych_strong;

import java.util.List;
public class AdapterRecyclerSlowaStronga extends RecyclerView.Adapter<AdapterRecyclerSlowaStronga.ViewHolder>
    {
        private List<Model_danych_strong> lista_stronga;


        public AdapterRecyclerSlowaStronga(List<Model_danych_strong> ladujSlowaStronga)
            {
this.lista_stronga=ladujSlowaStronga;
            }
        @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wyglad_wiersza_stronga,parent,false);
                return new AdapterRecyclerSlowaStronga.ViewHolder(view);
            }
        @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position)
            {
                holder.wyraz.setText(lista_stronga.get(position).getSlowo());
                holder.nrStronga.setText(lista_stronga.get(position).getNrStrong());
                holder.tlumaczenie.setText(lista_stronga.get(position).getTlumaczenie());
            }
        @Override public int getItemCount()
            {
                return lista_stronga.size();
            }
        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView wyraz,nrStronga,tlumaczenie;


            public ViewHolder(@NonNull View itemView)
                {
                    super(itemView);
                   wyraz = itemView.findViewById(R.id.id_tv_wyraz);
                   nrStronga = itemView.findViewById(R.id.id_tv_numerStrong);
                   tlumaczenie= itemView.findViewById(R.id.id_tv_tlumaczenie);
                }
        }
    }
