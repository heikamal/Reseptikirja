package com.example.reseptikirja;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {
    @PrimaryKey
    public int recipeId;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="time_requirement")
    public int timeRequirement;

    @ColumnInfo(name="image_id")
    public int imageId;

    @ColumnInfo(name="main_text")
    public String mainText;
}
