package com.example.acm_app_georgechan.Retrofit;

import com.example.acm_app_georgechan.Models.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MLHInterface {
    @GET("na-2019")
    Call<List<Event>> getEvents();
}
