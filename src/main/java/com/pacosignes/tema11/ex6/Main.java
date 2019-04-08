package com.pacosignes.tema11.ex6;



import com.github.javafaker.Faker;
import com.pacosignes.tema11.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    static Videoclub videoclub=new Videoclub();



    public static void main(String[] args) {
        Faker faker=new Faker(new Locale("es"));
        ArrayList<Multimedia.Formato> formatos=new ArrayList<>();
        ArrayList<Pelicula.Genero> generos=new ArrayList<>();
        formatos.add(Multimedia.Formato.ARCHIVO);
        formatos.add(Multimedia.Formato.BLUE_RAY);
        Map<Pelicula.Genero,Integer> map=new HashMap();



        //faker para socios
        for(int i=0;i<100;i++){

            videoclub.anyadirSocio(new Socio(faker.name().firstName(),faker.name().lastName(), Lib.fakerFechas("05/10/1992","08/10/2000")));
        }




        for(int i=0;i<100;i++){
            videoclub.anyadirMultimedia(new Pelicula(faker.harryPotter().book(),faker.artist().name(),new GregorianCalendar(),faker.number().randomDigit(),faker.name().firstName(),
                    faker.name().firstName(), Pelicula.Genero.ACCION,formatos ));

            System.out.println(videoclub.getSocios().get(i).toString());
        }

        for (Multimedia m:videoclub.getMultimedia()
             ) {
            System.out.println(m.toString());
        }


        for (Multimedia m:videoclub.getMultimedia()
             ) {
            for (Multimedia.Formato formato: m.getFormatos()
                 ) {
                videoclub.anyadirAlquilable(new Alquilable((Pelicula)m,formato));
            }
        }
        for (Alquilable a:videoclub.getAlquilables()
             ) {
            System.out.println(a.toString());
        }


        System.out.println(videoclub.alquilar(videoclub.getAlquilables().get(5),videoclub.getSocios().get(5)));

        for (FichaSocio ficha:videoclub.getFichasSocios()
             ) {
            for (Alquiler a: ficha.getAlquileresVigentes()
                 ) {
                System.out.println(a.toString());
            }
        }

        System.out.println(videoclub.devolverAlquilable(videoclub.getAlquilables().get(5)));
        for (FichaSocio ficha:videoclub.getFichasSocios()
        ) {
            for (Alquiler a: ficha.getAlquileresVigentes()
            ) {
                System.out.println(a.toString());
            }
        }
        for(FichaSocio ficha: videoclub.getFichasSocios()){
            for(Alquiler a: ficha.getAlquileres()){
                System.out.println(a.toString());
            }
        }
    }



}
