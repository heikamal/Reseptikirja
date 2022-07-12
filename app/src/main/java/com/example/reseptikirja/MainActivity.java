package com.example.reseptikirja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static RecipeDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //tietokannan alustus
        database = Room.databaseBuilder(
                getApplicationContext(),
                RecipeDatabase.class,
                "database-name").allowMainThreadQueries().build();

        RecipeDao recipeDao = database.recipeDao();
        Recipe[] allRecipes = recipeDao.getAllRecipes();
        if(allRecipes.length == 0) InitiateRecipes(recipeDao);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void InitiateRecipes(RecipeDao dao)
    {
        Recipe r1 = new Recipe();

        r1.name = "Lihapullat";
        r1.timeRequirement = 30;
        r1.mainText = "1. Sekoita sipulikeittoainekset, korppujauhot, pippuri, kermaviili tai " +
                "vesi ja muna keskenään. Anna turvota 10 minuuttia.\n" +
                "2. Lisää jauheliha ja vaivaa jauhelihamassa tasaiseksi.\n" +
                "3. Muotoile taikinasta vedellä kostutetuin käsin lihapullia (noin 40 kpl).\n" +
                "4. Paista uunissa 225-asteessa noin 15 minuuttia. Voit myös paistaa lihapullat " +
                "kypsiksi öljyssä pannulla.\n";

        r1.imageId = getResources().
                getIdentifier("meatballs", "drawable", getPackageName());

        Recipe r2 = new Recipe();

        r2.name = "Suklaabrownie";
        r2.timeRequirement = 40;
        r2.mainText = "Laita uuni lämpenemään 175 asteeseen. Sulata voi kattilassa. " +
                "Ota kattila pois liedeltä ja lisää sulaneen voin joukkoon paloiteltu suklaa. " +
                "Sekoittele, kunnes suklaa on sulanut. Vatkaa munat ja sokeri kulhossa vaahdoksi. "+
                "Lisää joukkoon vaniljasokeri ja rouhitut pähkinät. " +
                "Sekoita keskenään vehnäjauho ja leivinjauhe, " +
                "lisää jauhoseos muna-sokeri seokseen. " +
                "Lisää lopuksi joukkoon suklaa-voiseos ja sekoita taikina tasaiseksi. " +
                "Kaada taikina uunipannuun (noin 20cm x 30cm) ja paista noin 30 minuuttia tai " +
                "kunnes taikina alkaa vähän jähmettyä keskeltä. Jäähdytä brownie " +
                "kokonaan ja leikkaa paloiksi.\n";
        r2.imageId = getResources().
                getIdentifier("chocolatebrownie", "drawable", getPackageName());


        dao.insertAll(r1,r2);
    }
}