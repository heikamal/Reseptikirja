package com.example.reseptikirja;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ItemListFragment extends Fragment {

    public ItemListFragment() {super(R.layout.fragment_item_list);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        RecyclerView rvItemList = view.findViewById(R.id.rvRecipeList);

        Recipe[] dataset = MainActivity.database.recipeDao().getAllRecipes();
        rvItemList.setAdapter(new RecipeListAdapter(dataset));
        rvItemList.setLayoutManager(new LinearLayoutManager(getContext()));

        super.onViewCreated(view, savedInstanceState);
    }
}