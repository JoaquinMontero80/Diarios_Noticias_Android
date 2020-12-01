package com.jobeanda.miproyecto.ui.internacionales;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jobeanda.miproyecto.R;
import com.jobeanda.miproyecto.ui.internacionales.network.GetDataService;
import com.jobeanda.miproyecto.ui.internacionales.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActividadInternacionales extends Fragment
{
    private AdaptadorNoticias adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.recycler_noticias, container, false);

        // Barra progreso por si tarda en sincronizar
        progressDialog = new ProgressDialog(root.getContext());
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

        recyclerView = (RecyclerView)root.findViewById(R.id.recyclerNoticias);

        // Crea el servicio ( interfaz )
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        // Creo el objeto de tipo Call que tiene dentro el Comic
        // Cuando hace la llamada, lo busca pero el prgrama puede estar haciendo otras cosas ( asincronismo )
        Call<NoticiaInternacionalPadre> call = service.getNoticias();

        // Llamada a la API. Nos genera 2 métodos ( que quiero que pase con resuesta correcta/incorrecta)
        call.enqueue(new Callback<NoticiaInternacionalPadre>() {
            @Override
            public void onResponse(Call<NoticiaInternacionalPadre> call, Response<NoticiaInternacionalPadre> response) {
                progressDialog.dismiss();
                generateList(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NoticiaInternacionalPadre> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Falló la conexión", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void generateList(List<NoticiaInternacional> noticia) {
        adapter = new AdaptadorNoticias(noticia, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
