package com.badorek.luemon_app;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView, removeImage;
    CheckBox selectLutemon;
    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonExperience, lutemonMaxHealth;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.ivLutemonPicture);
        lutemonName = itemView.findViewById(R.id.tvLutemonName);
        lutemonAttack = itemView.findViewById(R.id.tvLutemonAttack);
        lutemonDefense = itemView.findViewById(R.id.tvLutemonDefense);
        lutemonExperience = itemView.findViewById(R.id.tvLutemonExperience);
        lutemonMaxHealth = itemView.findViewById(R.id.tvLutemonMaxHealth);
        removeImage = itemView.findViewById(R.id.imgRemove);
        selectLutemon = itemView.findViewById(R.id.cbSelectLutemon);
    }
}
