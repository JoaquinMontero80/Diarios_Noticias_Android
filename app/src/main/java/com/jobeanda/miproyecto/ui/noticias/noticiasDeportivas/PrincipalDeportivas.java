package com.jobeanda.miproyecto.ui.noticias.noticiasDeportivas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.jobeanda.miproyecto.R;


public class PrincipalDeportivas extends Fragment
{
    private ImageView imageMarca, imageAs, imageSport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.activity_principal_deportivas, container, false);

        imageMarca = (ImageView) root.findViewById(R.id.imageMarca);
        imageAs = (ImageView) root.findViewById(R.id.imageAs);
        imageSport = (ImageView) root.findViewById(R.id.imageSport);

        imageMarca.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasDeportivas.class);
                startActivity(intent);
            }
        });


        imageAs.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasDeportivasAs.class);
                startActivity(intent);
            }
        });

        imageSport.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActividadNoticiasSport.class);
                startActivity(intent);
            }
        });

        return root;

    } // Fin onCreateView


}