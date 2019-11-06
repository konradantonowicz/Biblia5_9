package com.example.biblia59.Adaptery;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia59.Fragmenty.FragmentNumerowRozdzialy;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceRozdzialy;
import com.example.biblia59.R;
public class AdapterRecyclerNumerowRozdzialy extends RecyclerView.Adapter<AdapterRecyclerNumerowRozdzialy.ViewHolder>
    {

        private String iloscRozdzialow;
        private SluchaczKliknietegoElementuInterfaceRozdzialy sluchaczKliknietegoElementuInterfaceRozdzialy;

        public AdapterRecyclerNumerowRozdzialy(String ilosc) {

            this.iloscRozdzialow = ilosc;
        }
        @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wyglad_wiersza_rozdzialow, parent, false);
                return new ViewHolder(view);
            }
        @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position)
            {
                holder.itemTv.setText(String.valueOf(position+1));
            }

        @Override public int getItemCount()
            {
                return Integer.parseInt(iloscRozdzialow);
            }
        public void ustawSluczhaczakliknietegoRoz(FragmentNumerowRozdzialy fragmentNumerowRozdzialy)
            {
                sluchaczKliknietegoElementuInterfaceRozdzialy =  fragmentNumerowRozdzialy;
            }
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView itemTv;
            public ViewHolder(@NonNull View itemView)
                {
                    super(itemView);
                    itemTv = itemView.findViewById(R.id.tv_rozdzial);
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override public void onClick(View view)
                            {
                                sluchaczKliknietegoElementuInterfaceRozdzialy.klik_na_rozdzial(getAdapterPosition());
                            }
                    });

                }
        }
    }
