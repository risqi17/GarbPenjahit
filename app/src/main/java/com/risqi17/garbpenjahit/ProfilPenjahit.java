package com.risqi17.garbpenjahit;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfilPenjahit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_penjahit);

        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String ids = sharedPreferences.getString(Config.ID_SHARED_PREF, "Not Available");
        getSupportActionBar().setTitle(ids);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
