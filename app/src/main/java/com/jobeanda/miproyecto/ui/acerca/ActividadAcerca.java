package com.jobeanda.miproyecto.ui.acerca;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.jobeanda.miproyecto.R;
import com.jobeanda.miproyecto.ui.noticias.Detalles;

public class ActividadAcerca extends Fragment
{
    // Variables de AppCompatButton
    private AppCompatButton botoncontactar, botonterminos, botonGooglePlay, botonCompartir, botonotrasapp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.activity_acerca, container, false);

        //Recoge en R la dirección de cada componente
        botoncontactar = (AppCompatButton) root.findViewById(R.id.botoncontactar);
        botonterminos = (AppCompatButton) root.findViewById(R.id.botonterminos);
        botonGooglePlay = (AppCompatButton) root.findViewById(R.id.botonGooglePlay);
        botonCompartir = (AppCompatButton) root.findViewById(R.id.botonCompartir);
        botonotrasapp = (AppCompatButton) root.findViewById(R.id.botonotrasapp);

        // Inicializa la direccion de la aplicacion en GooglePlay
        final String direccionAplicacion = "https://play.google.com/store/apps/details?id=com.Jobeanda.Lahuidadelamazmorra&hl=es&gl=US";
        final String direccionDesarrollador = "https://play.google.com/store/apps/developer?id=JOBEANDA+STUDIOS&hl=es&gl=US";


//======================================================================================================

        // Al pulsar "contactar" envia un email a la direccion establecida del desarrollador
        botoncontactar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String[] direccionmail = {"socrates.descartes.1980@gmail.com"}; //Direcciones email  a enviar.

                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, direccionmail);
                emailIntent.putExtra(Intent.EXTRA_CC, direccionmail);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, ""); // Aquí escribe el asunto
                emailIntent.putExtra(Intent.EXTRA_TEXT, ""); // * configurar texto de email aquí!

                try {
                    startActivity(Intent.createChooser(emailIntent, "Enviar email."));
                    Log.i("EMAIL", "Enviando email...");
                }
                catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(getContext(), "No existe ninguna apliación de email instalada!."
                            + "'", Toast.LENGTH_SHORT).show();
                }
            }
        });


//=====================================================================================================

        // Al pulsar "términos y condicones" abre una nueva actividad con descripcion
        botonterminos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), ActividadSobreNosotros.class);
                getContext().startActivity(intent);
            }
        });


//======================================================================================================

        // Al pulsar "califícanos en Google Play"
        botonGooglePlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                // Lo mando directamente a la direccion de la aplicacion para que evalue
                Uri uri = Uri.parse(direccionAplicacion);
                Intent linkMyApp = new Intent(Intent.ACTION_VIEW, uri);

                try {
                    startActivity(linkMyApp);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getContext(), "No tienes Google Play instalado!, no se lo digas a nadie y corre a instalarlo."
                            + "'", Toast.LENGTH_SHORT).show();
                }
            }
        });


//======================================================================================================

        // Al pulsar "compartir app", comparte el enlace a GooglePlay de la app en otra aplicacion del dispositivo instalada
        botonCompartir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                // Es necesario un intent que levante la actividad deseada
                Intent sendIntent = new Intent();
                // La accion es un envio a una aplicacion externa
                sendIntent.setAction(Intent.ACTION_SEND);
                // Enlace que vamos a enviar
                sendIntent.putExtra(Intent.EXTRA_TEXT, direccionAplicacion);
                // Se va a enviar un texto plano
                sendIntent.setType("text/plain");

                // manda mensaje si no tiene aplicacion con la que compartir en el sistema
                Intent shareIntent = Intent.createChooser(sendIntent, "no tengo aplicacion para compartir en emulador");
                // Inicia la actividad compartir enlace de la noticia
                getContext().startActivity(shareIntent);
            }
        });

//======================================================================================================

        // Al pulsar "otras App del desarrollador", muestra el enlace de la cuenta de desarrolaldor de FGoogle Play del desarrollador
        botonotrasapp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                // Carga la nueva actividad ( calse Detalles - activity_detalles.xml )
                Intent intent = new Intent(getContext(), Detalles.class);
                // Enlace a la web de la noticia
                intent.putExtra("Enlace", direccionDesarrollador);
                startActivity(intent);
            }
        });

//===================
        return root;

    } // Fin de onCreateView

} // Find e clase
