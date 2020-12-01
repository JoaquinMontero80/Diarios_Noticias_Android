package com.jobeanda.miproyecto.ui.noticias.noticiasTecnologia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.jobeanda.miproyecto.R;

public class PrincipalTecnologia extends Fragment
{
    private ImageView imageVanguardia, imageDigital;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.activity_principal_tecnologia, container, false);

        imageVanguardia = (ImageView) root.findViewById(R.id.imageVanguardia);
        imageDigital = (ImageView) root.findViewById(R.id.imageDigital);

        imageVanguardia.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasTecnologia.class);
                startActivity(intent);
            }
        });

        imageDigital.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasDigitalTrend.class);
                startActivity(intent);
            }
        });


        return root;

    } // Fin onCreateView


}