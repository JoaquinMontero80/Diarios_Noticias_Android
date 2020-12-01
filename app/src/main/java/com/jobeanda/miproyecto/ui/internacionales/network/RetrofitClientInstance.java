package com.jobeanda.miproyecto.ui.internacionales.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    // Instancia a Retrofit
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://newsapi.org/v2/";

    public static Retrofit getRetrofitInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
