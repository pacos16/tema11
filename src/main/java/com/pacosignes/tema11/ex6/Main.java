package com.pacosignes.tema11.ex6;



import com.github.javafaker.Faker;
import com.pacosignes.tema11.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    static Videoclub videoclub=new Videoclub();
    static Scanner lector=new Scanner(System.in);


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
        int opcion=0;
        do{
            do{
                menuPrincipal();
                try{
                    opcion=Integer.parseInt(lector.nextLine());
                }catch(NumberFormatException nfe){
                    System.out.println("Introduce un numero correcto");
                    opcion=-1;
                }
                if(opcion<0 || opcion >4){
                    System.out.println("Introduce un numero correcto");
                }
            }while(opcion<0 || opcion >4);


            switch (opcion){
                case 1:
                    int opcion1=-1;
                    do{
                        System.out.println("ALQUILAR/DEVOLVER");
                        System.out.println("-----------------");
                        System.out.println("1.Alquilar");
                        System.out.println("2.Devolver");
                        System.out.println("----------");
                        System.out.println("0.Volver");
                        try {
                            opcion1 = Integer.parseInt(lector.nextLine());
                            if(opcion1<0 || opcion1>2){
                                System.out.println("Introduce un numero de la lista");
                            }else{
                                if(opcion1==1){
                                    //todo alquilar();
                                }else if (opcion1==2){
                                    //todo devolver();
                                }
                            }
                        }catch (NumberFormatException nfe){
                            System.out.println("Introduce un numero porfavor");
                        }
                    }while (opcion1!=0);
                    break;
                case 2:
                    int opcion2=-1;
                    do {
                        System.out.println("MULTIMEDIA");
                        System.out.println("----------");
                        System.out.println("1.Anyadir");
                        System.out.println("2.Borrar");
                        System.out.println("--------");
                        System.out.println("0.Volver");
                        try {
                            opcion2 = Integer.parseInt(lector.nextLine());
                            if (opcion2 < 0 || opcion2 > 2) {
                                System.out.println("Introduce un numero de la lista");
                            } else {
                                if (opcion2 == 1) {
                                    //todo anyadirMultimedia();
                                } else if (opcion2 == 2) {
                                    //todo borrarMultimedia();
                                }
                            }
                        } catch (NumberFormatException nfe) {
                            System.out.println("Introduce un numero porfavor");
                        }
                    }while(opcion2!=0);
                    break;
                case 3:
                    int opcion3=-1;
                    do {
                        System.out.println("SOCIOS");
                        System.out.println("----------");
                        System.out.println("1.Anyadir");
                        System.out.println("2.Borrar");
                        System.out.println("--------");
                        System.out.println("0.Volver");
                        try {
                            opcion3 = Integer.parseInt(lector.nextLine());
                            if (opcion3 < 0 || opcion3 > 2) {
                                System.out.println("Introduce un numero de la lista");
                            } else {
                                if (opcion3 == 1) {
                                    //todo anyadirSocio();
                                } else if (opcion3 == 2) {
                                    //todo borrarSocio();
                                }
                            }
                        } catch (NumberFormatException nfe) {
                            System.out.println("Introduce un numero porfavor");
                        }
                    }while(opcion3!=0);
                    break;
                case 4:
                    int opcion4=-1;
                    do{
                        System.out.println("INFORMES");
                        System.out.println("--------");
                        System.out.println("1.Todos los Multimedia");
                        System.out.println("2.Todos los Alquilables");
                        System.out.println("3.Peliculas por titulo");
                        System.out.println("4.Videojuegos por anyo");
                        System.out.println("5.Historicos de alquiler de socio");
                        System.out.println("6.Listado de socios con recargo");
                        try{
                            opcion4= Integer.parseInt(lector.nextLine());

                        }catch (NumberFormatException nfe){
                            System.out.println("Number format exception");
                        }
                        switch (opcion4){

                        }
                    }while(opcion4!=0);
            }


        }while(opcion!=0);
    }


    public static void menuPrincipal(){
        System.out.println("  Videoclub");
        System.out.println("  ---------");
        System.out.println("1.Alquilar/devolver");
        System.out.println("2.Multimedia");
        System.out.println("3.Socios");
        System.out.println("4.Informes");
        System.out.println("-------------");
        System.out.println("0.Salir programa");
    }

}

