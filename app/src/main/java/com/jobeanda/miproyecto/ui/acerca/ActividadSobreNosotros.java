package com.jobeanda.miproyecto.ui.acerca;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.jobeanda.miproyecto.R;

public class ActividadSobreNosotros extends AppCompatActivity {

    // Numero de paginas
    private static final int PAGINAS = 13;

    // ViewPager y adaptador
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobrenosotros);

        iniciarComponente();

    }


    private void iniciarComponente()
    {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        myViewPagerAdapter = new MyViewPagerAdapter();

        // Introduce al adaptador al ViewPager, hace que cambie de página al deslizar
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });

    }

    /**
     * Adaptador ViewPager ( https://developer.android.com/reference/kotlin/androidx/viewpager/widget/PagerAdapter )
     */
    public class MyViewPagerAdapter extends PagerAdapter
    {
        private LayoutInflater layoutInflater;

        // Constructor sin parametros


        // Sobreescribe metodo. Crea la página para la posición dada. El adaptador es responsable de agregar la vista
        // al contenedor que se proporciona aquí, aunque solo debe asegurarse de que esto se haga para cuando regrese
        // https://developer.android.com/reference/androidx/viewpager/widget/PagerAdapter#instantiateItem(android.view.ViewGroup,%20int)
        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item_condiciones, container, false);
            TextView text = (TextView) view.findViewById(R.id.text);

            // Si hay elementos
            if (position > 0)
            {
                text.setVisibility(View.VISIBLE);
                // Referencia al RelativeLayout
                (view.findViewById(R.id.lyt_article_cover)).setVisibility(View.GONE);

                // Posicion de la pagina
                switch(position)
                {
                    case 1:
                        text.setText(R.string.clausula1);
                        break;
                    case 2:
                        text.setText(R.string.clausula2);
                        break;
                    case 3:
                        text.setText(R.string.clausula3);
                        break;
                    case 4:
                        text.setText(R.string.clausula4);
                        break;
                    case 5:
                        text.setText(R.string.clausula5);
                        break;
                    case 6:
                        text.setText(R.string.clausula6);
                        break;
                    case 7:
                        text.setText(R.string.clausula7);
                        break;
                    case 8:
                        text.setText(R.string.clausula8);
                        break;
                    case 9:
                        text.setText(R.string.clausula9);
                        break;
                    case 10:
                        text.setText(R.string.clausula10);
                        break;
                    case 11:
                        text.setText(R.string.clausula11);
                        break;
                    case 12:
                        text.setText(R.string.clausula12);
                        break;
                }
            }

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return PAGINAS;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
