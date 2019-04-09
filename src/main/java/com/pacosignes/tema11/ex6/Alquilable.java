package com.pacosignes.tema11.ex6;

public class Alquilable implements Comparable<Alquilable> {

    private static int autoIncremento=0;
    private int id;
    private Multimedia multimedia;
    Multimedia.Formato formato;
    Videojuego.Plataforma plataforma;

    public Alquilable(Pelicula pelicula, Multimedia.Formato formato){
        autoIncremento++;
        id=autoIncremento;
        multimedia=pelicula;
        this.formato=formato;
        plataforma=null;
    }
    public Alquilable(Videojuego videojuego, Multimedia.Formato formato, Videojuego.Plataforma plataforma){
        autoIncremento++;
        id=autoIncremento;
        multimedia=videojuego;
        this.formato=formato;
        this.plataforma=plataforma;
    }

    /*
    //copy constructor for game
    public Alquilable( Videojuego videojuego, Multimedia.Formato formato, Videojuego.Plataforma plataforma,int id) {
        this.id = id;
        this.multimedia = videojuego;
        this.formato = formato;
        this.plataforma = plataforma;
    }
    //copy constructor for peli
    public Alquilable(Pelicula pelicula, Multimedia.Formato formato,int id) {
        this.id = id;
        this.multimedia = pelicula;
        this.formato = formato;
        this.plataforma=null;
    }
     */

    public int getId() {
        return id;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public Multimedia.Formato getFormato() {
        return formato;
    }

    public Videojuego.Plataforma getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {

        if(multimedia instanceof Videojuego) {
            return "Videojuego Alquilable{" +
                    "Id=" + id +
                    ", Nombre=" + multimedia.getNombre() +
                    ", Autor=" + multimedia.getAutor() +
                    ", formato=" + formato +
                    ", Plataforma=" + plataforma +
                    '}';
        }else{
            return "Pelicula Alquilable{" +
                    "Id=" + id +
                    ", Nombre=" + multimedia.getNombre() +
                    ", Autor=" + multimedia.getAutor() +
                    ", Formato=" + formato +
                    '}';
        }
    }

    @Override
    public int compareTo(Alquilable o) {
        return this.id-o.id;
    }
}
