package com.pacosignes.tema11.ex6;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Multimedia implements Comparable<Multimedia> {

    public enum Formato {
        CD("Compact Disc"),DVD("DVD"),BLUE_RAY("Blue Ray"),ARCHIVO("Archivo");
        private String nombre;
        Formato(String nombre){
            this.nombre=nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    protected String nombre;
    protected String autor;
    protected GregorianCalendar fechaEstreno;
    protected ArrayList<Formato> formatos;

    public Multimedia(String nombre, String autor, GregorianCalendar fechaEstreno, ArrayList<Formato> formatos) {
        this.nombre = nombre;
        this.autor = autor;
        this.fechaEstreno = fechaEstreno;
        this.formatos=formatos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public GregorianCalendar getFechaEstreno() {
        return fechaEstreno;
    }

    public ArrayList<Formato> getFormatos() {
        return formatos;
    }


    public boolean equals(Multimedia multimedia){

        return multimedia.nombre.equals(this.nombre) && multimedia.autor.equals(this.autor) &&
                multimedia.getClass().equals(this.getClass()) && multimedia.fechaEstreno.equals(this.fechaEstreno);
    }

    @Override
    public String toString() {

        SimpleDateFormat fechaFormat= new SimpleDateFormat("dd,MM,yyyy");
        Date date=fechaEstreno.getTime();
        return "Multimedia{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaEstreno=" + fechaFormat.format(date) +
                ", formatos=" + formatos +
                '}';
    }


    public int compareTo(Multimedia multimedia){

        return this.nombre.compareTo(multimedia.nombre);
    }
    public static class ComparatorFecha implements Comparator<Multimedia> {


        public int compare(Multimedia o,Multimedia o1) {
                if(o.fechaEstreno.before(o1.fechaEstreno)){
                    return 1;
                }else{
                    return -1;
                }
        }
    }
}
