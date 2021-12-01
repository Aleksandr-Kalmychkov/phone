package com.example.signinup;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class FilmInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        filmsAdapter adapter = new filmsAdapter(getLayoutInflater(), MyHelper.Urls);
        recyclerView.setAdapter(adapter);
    }
}