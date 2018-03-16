package com.vagapov.amir.recyclerviewcollapseex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        movies = setupList();
        CollapseAdapter adapter = new CollapseAdapter(movies);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ((SimpleItemAnimator)rv.getItemAnimator()).setSupportsChangeAnimations(false);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(false);
    }

    private ArrayList<Movie> setupList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Pulp Fiction", "Drama, Comedy", 1998));
        movieList.add(new Movie("Догма", "Комедия, Мистика", 2003));
        movieList.add(new Movie("Один дома", "Комедия", 1992));
        movieList.add(new Movie("Шерлок", "Сериал, Детекив", 2010));
        movieList.add(new Movie("Игра престолов", "Фентези", 2009));
        movieList.add(new Movie("Schindler's List", "Biography, Drama, History", 1993));
        movieList.add(new Movie("Pulp Fiction", "Crime, Drama", 1994));
        movieList.add(new Movie("No Country for Old Men", "Crime, Drama, Thriller", 2007));
        movieList.add(new Movie("Léon: The Professional", "Crime, Drama, Thriller", 1994));
        movieList.add(new Movie("Fight Club", "Drama", 1999));
        movieList.add(new Movie("Forrest Gump", "Drama, Romance", 1994));
        movieList.add(new Movie("The Shawshank Redemption", "Crime, Drama", 1994));
        movieList.add(new Movie("The Godfather", "Crime, Drama", 1972));
        movieList.add(new Movie("A Beautiful Mind", "Biography, Drama", 2001));
        movieList.add(new Movie("Good Will Hunting", "Drama", 1997));
        return movieList;
    }
}
