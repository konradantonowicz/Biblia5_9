package com.example.biblia59.Adaptery;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.biblia59.Fragmenty.FragmentNazwyKsiag;
import com.example.biblia59.Interface.SluchaczKliknietegoElementuInterfaceKsiegi;
import com.example.biblia59.R;
import com.example.biblia59.Rozne.Ksiegi;

import java.util.List;
public class AdapterRecyclerNazwKsiag extends RecyclerView.Adapter<AdapterRecyclerNazwKsiag.ViewHolder>
    {
        private List<Ksiegi> listaKsiag;
        private SluchaczKliknietegoElementuInterfaceKsiegi sluchaczKliknietegoElementuInterfaceKsiegi;

        public AdapterRecyclerNazwKsiag(List<Ksiegi> listaKsiag)
            {
                this.listaKsiag = listaKsiag;
            }
        @NonNull @Override public AdapterRecyclerNazwKsiag.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType
        )
            {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wyglad_wiersza_ksiag, viewGroup, false);
                return new ViewHolder(view);
            }
        @Override public void onBindViewHolder(@NonNull AdapterRecyclerNazwKsiag.ViewHolder holder, int position)
            {
                holder.itemTv.setText(listaKsiag.get(position).getNazwaKsiegi());
                holder.itemImage.setImageResource(listaKsiag.get(position).getIkonaKomentarza());
            }

        @Override public int getItemCount()
            {
                return listaKsiag.size();
            }
        public void UstawSluczaczaKlikniecia(FragmentNazwyKsiag fragmentNazwyKsiag)
            {
                sluchaczKliknietegoElementuInterfaceKsiegi =  fragmentNazwyKsiag;
            }
        class ViewHolder extends RecyclerView.ViewHolder
            {
                TextView itemTv;
                ImageView itemImage;
                ViewHolder(View itemView)
                    {
                        super(itemView);
                        itemTv = itemView.findViewById(R.id.tv_ksiega);
                        itemImage = itemView.findViewById(R.id.id_image_komentarz);
                        itemView.setOnClickListener(new View.OnClickListener() {
                            @Override public void onClick(View view)
                                {
                                    sluchaczKliknietegoElementuInterfaceKsiegi.klik_na_ksiega(itemTv.getText().toString());
                                }
                        });
                        itemImage.setOnClickListener(new View.OnClickListener() {
                            @Override public void onClick(View view)
                                {
                                    sluchaczKliknietegoElementuInterfaceKsiegi.klik_na_komentarz(itemTv.getText().toString());
                                }
                        });
                    }

            }




    }