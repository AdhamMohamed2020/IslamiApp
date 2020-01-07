package com.route.islamiApp.APi;

import com.route.islamiApp.model.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface WebServices {


    @GET("radio_arabic.json")
    Call<RadiosResponse> getRadioChannels();
}
