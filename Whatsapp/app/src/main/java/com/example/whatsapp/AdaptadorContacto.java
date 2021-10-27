package com.example.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorContacto extends ArrayAdapter<Contacto> {

    private Contacto[] datos;

    public AdaptadorContacto(@NonNull Context context, Contacto[] datos) {
        super(context, R.layout.chat_layout, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.chat_layout, null);

        TextView nombre = (TextView) item.findViewById(R.id.nombre);
        nombre.setText(datos[position].getNombre());

        TextView mensaje = (TextView) item.findViewById(R.id.mensaje);
        mensaje.setText(datos[position].getUltimoMensaje());

        TextView fecha = (TextView) item.findViewById(R.id.fecha);
        fecha.setText(datos[position].getFecha());

        ImageView img = (ImageView) item.findViewById(R.id.imagen);
        img.setImageDrawable(datos[position].getImg().getDrawable());

        return item;
    }
}
