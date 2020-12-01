package com.jobeanda.miproyecto.ui.noticias.noticiasGenerales;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.jobeanda.miproyecto.R;


public class PrincipalGenerales extends Fragment
{
    private ImageView imageVeinte, imageElpais, imageMeneame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.activity_principal_generales, container, false);

        imageVeinte = (ImageView) root.findViewById(R.id.imageVeinte);
        imageElpais = (ImageView) root.findViewById(R.id.imageElPais);
        imageMeneame = (ImageView) root.findViewById(R.id.imageMeneame);

        imageVeinte.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticias.class);
                startActivity(intent);
            }
        });

        imageElpais.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasElPais.class);
                startActivity(intent);
            }
        });

        imageMeneame.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasMeneame.class);
                startActivity(intent);
            }
        });

        return root;

    } // Fin onCreateView


}