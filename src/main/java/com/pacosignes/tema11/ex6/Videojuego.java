package com.pacosignes.tema11.ex6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Videojuego extends Multimedia {

    public enum Plataforma{

        XBOX("X Box"),NINTENDO_Switch("Nintendo Switch"),PS4("Play Station 4"),
        PS3("Play Station 3"),ORDENADOR("Ordenador");
        String nombre;
        Plataforma(String nombre){
            this.nombre=nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }


    private ArrayList<Plataforma> plataformas;


    public Videojuego(String nombre, String autor, GregorianCalendar fechaEstreno, ArrayList<Plataforma> plataformas , ArrayList<Formato> formatos) {
        super(nombre, autor, fechaEstreno, formatos);
        this.plataformas = plataformas;
    }

    @Override
    public String toString() {
        SimpleDateFormat fechaFormat= new SimpleDateFormat("dd,MM,yyyy");
        Date date=fechaEstreno.getTime();
        return "Videojuego{" +
                "  nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaEstreno=" + fechaFormat.format(date) +
                ", formatos=" + formatos +
                ", plataformas=" + plataformas +
                '}';
    }
}
