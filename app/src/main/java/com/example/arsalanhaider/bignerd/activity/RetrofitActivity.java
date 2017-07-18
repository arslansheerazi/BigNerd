package com.example.arsalanhaider.bignerd.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.arsalanhaider.bignerd.MainActivity;
import com.example.arsalanhaider.bignerd.R;
import com.example.arsalanhaider.bignerd.model.Movie;
import com.example.arsalanhaider.bignerd.model.MovieResponse;
import com.example.arsalanhaider.bignerd.webservice.ApiClient;
import com.example.arsalanhaider.bignerd.webservice.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "9f2407802141cd86e89f1d4d9d275c68";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }//end of on create
}
