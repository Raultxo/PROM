package com.example.whatsapp;

import android.widget.ImageView;

public class Contacto {

    private String nombre, ultimoMensaje, fecha;
    private ImageView img;

    public Contacto(String nombre, String ultimoMensaje, String fecha, ImageView img) {
        this.nombre = nombre;
        this.ultimoMensaje = ultimoMensaje;
        this.fecha = fecha;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUltimoMensaje() {
        return ultimoMensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public ImageView getImg() {
        return img;
    }
}
