package com.jobeanda.miproyecto.ui.noticias.noticiasEconomia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.jobeanda.miproyecto.R;

public class PrincipalEconomia extends Fragment
{
    private ImageView imageExpansion, imageCincodias, imagePortafolio, imageConfidencial;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.activity_principal_economia, container, false);

        imageExpansion = (ImageView) root.findViewById(R.id.imageExpansion);
        imageCincodias = (ImageView) root.findViewById(R.id.imageCincodias);
        imagePortafolio = (ImageView) root.findViewById(R.id.imagePortafolio);
        imageConfidencial = (ImageView) root.findViewById(R.id.imageElConfidencial);

        imageExpansion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasEconomia.class);
                startActivity(intent);
            }
        });

        imageCincodias.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasCincodias.class);
                startActivity(intent);
            }
        });

        imagePortafolio.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasPortafolio.class);
                startActivity(intent);
            }
        });

        imageConfidencial.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasConfidencial.class);
                startActivity(intent);
            }
        });

        return root;

    } // Fin onCreateView


}