package com.jobeanda.miproyecto.ui.noticias.noticiasTecnologia;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.jobeanda.miproyecto.R;


public class ActividadNoticiasDigitalTrend extends AppCompatActivity
{
    private RecyclerView recyclerViewNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_noticias);

        //root.setContentView(R.layout.activity_main_noticias);
        recyclerViewNoticias = (RecyclerView) findViewById(R.id.recyclerNoticias);

        // Instancia clase LectoRss ( constructor recibe Context ), le paso el RecyclerView
        LectorRssDigital lectorRss = new LectorRssDigital(this, recyclerViewNoticias);
        lectorRss.execute();
    }
}