package com.example.reseptikirja;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeListAdapter extends
        RecyclerView.Adapter<RecipeListAdapter.ViewHolder>{

    Recipe[] localDataset;

    public RecipeListAdapter(Recipe[] dataset){
        localDataset = dataset;
    }

    @NonNull
    @Override
    public RecipeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(RecipeListClickListener);

        holder.textView.setText(localDataset[position].name);
        holder.imageView.setImageResource(localDataset[position].imageId);
    }

    @Override
    public int getItemCount() {
        return localDataset.length;
    }

    View.OnClickListener RecipeListClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            Bundle bundle = new Bundle();
            bundle.putString("recipeName", localDataset[position].name);
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.itemDetailsFragment, bundle);
        }
    };

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final ImageView imageView;
        public final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.ivRecipeIcon);
            textView = (TextView) itemView.findViewById(R.id.tvRecipeName);
        }
    }
}
