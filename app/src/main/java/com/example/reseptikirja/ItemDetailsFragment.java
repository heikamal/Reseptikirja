package com.example.reseptikirja;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailsFragment extends Fragment {

    public ItemDetailsFragment() {super(R.layout.fragment_item_details);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        ImageView ivRecipeImage = view.findViewById(R.id.ivRecipeImage);
        TextView tvRecipeName = view.findViewById(R.id.tvRecipeName);
        TextView tvRecipeText = view.findViewById(R.id.tvRecipeMainText);
        TextView tvRecipeTime = view.findViewById(R.id.tvRecipeTimeRequired);

        String recipeName = getArguments().getString("recipeName");

        Recipe recipe = MainActivity.database.recipeDao().findByName(recipeName);
        if(recipe != null){
            ivRecipeImage.setImageResource(recipe.imageId);
            tvRecipeName.setText(recipe.name);
            tvRecipeText.setText(recipe.mainText);
            tvRecipeTime.setText("" + recipe.timeRequirement + " min");
        }
    }
}