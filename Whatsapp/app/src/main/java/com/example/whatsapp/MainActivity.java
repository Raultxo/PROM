package com.example.whatsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.example.whatsapp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Contacto[] datosContacto;
    private ListView listaChats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        listaChats = (ListView) findViewById(R.id.listaChats);
        cargarDatos();

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdapter());

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void cargarDatos()  {
        ImageView imgPlaceholder = new ImageView(this);
        imgPlaceholder.setImageResource(R.drawable.placeholder);

        datosContacto = new Contacto[] {
                new Contacto("Contacto 1", "Hey", "05/10/2021", imgPlaceholder),
                new Contacto("Contacto 2", "Que tal", "Ayer", imgPlaceholder)
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    class PageAdapter extends PagerAdapter {
        private LinearLayout pestana1, pestana2, pestana3;
        private final int[] pestanas ={R.string.tab1, R.string.tab2, R.string.tab3};

        @Override
        public int getCount() {
            return 3;
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String s = getString(pestanas[position]);
            return s;
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View page;
            switch (position) {
                case 0:
                    if (pestana1 == null) {
                        pestana1 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab1, container, false);
                    }
                    page = pestana1;
                    listaChats = (ListView) findViewById(R.id.listaChats2);
                    AdaptadorContacto adaptadorContacto = new AdaptadorContacto(pestana1.getContext(), datosContacto);
                    System.out.println(listaChats);
     //               listaChats.setAdapter(adaptadorContacto);
                    break;
                case 1:
                    if (pestana2 == null) {
                        pestana2 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab2,container,false);
                    }
                    page=pestana2;
                    break;
                default:
                    if (pestana3 == null) {
                        pestana3 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab3,container,false);
                    }
                    page=pestana3;
                    break;
            }
            container.addView(page, 0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }
}