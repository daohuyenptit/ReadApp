package com.example.dell.tt_readartist.Retrofit;

import android.content.Intent;

import com.example.dell.tt_readartist.Entites.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dell on 4/23/2018.
 */

public interface GitHubService {
    @GET("rss/{category}.rss")
    Call<Feed> getNewsByCategory(@Path("category") String category);

}
