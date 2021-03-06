package io.github.cointify.moviebuy;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class PopularMoviesActivity extends ActionBarActivity {

    ImdbMovieAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movies);

        recyclerView = (RecyclerView) findViewById(R.id.popularMoviesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new DownloadImdbMovies().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_popular_movies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DownloadImdbMovies extends AsyncTask<Void, Void, List<ImdbMovie>> {

        @Override
        protected List<ImdbMovie> doInBackground(Void... params) {
            ImdbApi api = RestClient.getApi();
            List<ImdbMovie> movies =api.getMovies("popularity.desc");
            return movies;
        }

        @Override
        protected void onPostExecute(List<ImdbMovie> imdbMovies) {
            adapter = new ImdbMovieAdapter(imdbMovies);
            recyclerView.setAdapter(adapter);
        }
    }
}
