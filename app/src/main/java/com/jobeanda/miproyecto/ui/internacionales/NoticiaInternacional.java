package com.jobeanda.miproyecto.ui.internacionales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NoticiaInternacional
{
    @SerializedName("title")
    @Expose
    private String titulo;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("url")
    @Expose
    private String enlace;

    @SerializedName("urlToImage")
    @Expose
    private String url_imagen;

    @SerializedName("publishedAt")
    @Expose
    private String fecha;




    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String url) {
        this.enlace = url;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String urlToImage) {
        this.url_imagen = urlToImage;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String publishedAt) {
        this.fecha = publishedAt;
    }
}
