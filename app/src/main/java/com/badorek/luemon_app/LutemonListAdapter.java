package com.badorek.luemon_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonName.setText(String.valueOf(lutemons.get(position).getName()));
        holder.lutemonAttack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.lutemonDefense.setText("Puolustus: " + String.valueOf(lutemons.get(position).getDefense()));
        holder.lutemonExperience.setText("Kokemus: " + lutemons.get(position).getExperience());
        holder.lutemonMaxHealth.setText("Maksimi elämäpisteet: " + String.valueOf(lutemons.get(position).getMaxHealth()));
        holder.imageView.setImageResource(lutemons.get(position).getImage(lutemons.get(position).getColor()));

        holder.removeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Storage.getInstance().removeLutemon(lutemons.get(holder.getAdapterPosition()).getName());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });

        holder.selectLutemon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Storage.getInstance().addSelectedLutemons(holder.getAdapterPosition());
                } else {
                    Storage.getInstance().removeSelectedLutemons(holder.getAdapterPosition());
                }

            }

        });

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
