package com.pacosignes.tema11.ex6;

public class Alquilable {
        private static int autoIncremento=0;
        private Multimedia multimedia;
        Multimedia.Formato formato;
        Videojuego.Plataforma plataforma;

        public Alquilable(Pelicula pelicula, Multimedia.Formato formato){
            multimedia=pelicula;
            this.formato=formato;
            plataforma=null;
        }
        public Alquilable(Videojuego videojuego, Multimedia.Formato formato, Videojuego.Plataforma plataforma){
            multimedia=videojuego;
            this.formato=formato;
            this.plataforma=plataforma;
        }



}
