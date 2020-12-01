package com.jobeanda.miproyecto.ui.internacionales.network;

import com.jobeanda.miproyecto.ui.internacionales.NoticiaInternacionalPadre;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataServiceIng {
    @GET("top-headlines?country=gb&apiKey=6ecafdda65254a46bacc006326d89a2a")
    Call<NoticiaInternacionalPadre> getNoticias();
}
