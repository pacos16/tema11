package com.pacosignes.tema11.ex6;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Pelicula extends Multimedia{


    public enum Genero{
        DRAMA("Drama"),COMEDIA("Comedia"),COMEDIA_ROMANTICA("Comedia Romantica"),
        ACCION("Accion"),XXX("XXX"),AVENTURAS("Aventuras"),INFANTIL("Infantil");

        String nombre;
        Genero(String nombre){
            this.nombre=nombre;
        }
    }

    private int duracion;
    private String actrizPrincipal;
    private String actorPrincipal;
    private Genero genero;

    public Pelicula(String nombre, String autor, GregorianCalendar fechaEstreno, int duracion,
                    String actrizPrincipal, String actorPrincipal, Genero genero, ArrayList<Formato> formatos) {
        super(nombre, autor, fechaEstreno, formatos);
        this.duracion = duracion;
        this.actrizPrincipal = actrizPrincipal;
        this.actorPrincipal = actorPrincipal;
        this.genero=genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre: '" + nombre + '\'' +
                ", autor: '" + autor + '\'' +
                ", fechaEstreno: " + fechaEstreno +
                ", formatos: " + formatos +
                ", genero: " + genero.toString() +
                ", actriz principal: " + actrizPrincipal +
                ", actor principal: " + actorPrincipal +
                ", duracion: " +duracion+
                '}';
    }
}
