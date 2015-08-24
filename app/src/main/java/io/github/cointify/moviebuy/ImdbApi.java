package io.github.cointify.moviebuy;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

public interface ImdbApi {

    @GET("/discover/movie")
    List<ImdbMovie> getMovies(@Query("sort_by") String sortBy);
}
