package com.pacosignes.tema11.ex6;



import com.github.javafaker.Faker;
import com.pacosignes.tema11.Lib;
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
            videoclub.anyadirMultimedia(new Pelicula(faker.harryPotter().book(),faker.artist().name(),Lib.fakerFechas("05/10/2000","08/10/2018"),faker.number().randomDigit(),faker.name().firstName(),
                    faker.name().firstName(), Pelicula.Genero.ACCION,formatos ));

            System.out.println(videoclub.getSocios().get(i).toString());
        }
        Collections.sort(videoclub.getMultimedia());
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

        videoclub.getMultimedia().sort(new Multimedia.ComparatorFecha());

        for (Multimedia m:videoclub.getMultimedia()
        ) {
            System.out.println(m.toString());
        }
        //aqui
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
                                    alquilar();
                                }else if (opcion1==2){
                                    devolver();
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
                        System.out.println("6.Listado de socios con recargo pendiente");
                        System.out.println("--------------------------------");
                        System.out.println("0.Volver");
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

    public static void alquilar(){
        boolean existe=false;
        int idsocio;
        Socio socio1=videoclub.getSocios().get(0);
        Alquilable alquilable1;
        System.out.println("Dime la id del socio");
        do{
            boolean numero=false;
            do {
                try {
                    idsocio = Integer.parseInt(lector.nextLine());
                    numero=true;
                } catch (NumberFormatException nfe) {
                    System.out.println("Introduce un numero");
                    idsocio=0;

                }
            }while (!numero);
            for (Socio socio : videoclub.getSocios()
            ) {
                if (socio.getIdSocio() == idsocio) {

                    socio1=socio;
                    existe = true;
                    System.out.println("El socio es "+socio.toString());
                    Lib.pausa();
                }
            }
            if(!existe){

                System.out.println("El cliente no existe");
                Lib.pausa();

            }

        }while(!existe);
        for (FichaSocio ficha:videoclub.getFichasSocios()
             ) {
            if(socio1.equals(ficha.getSocio())){
                for (Alquiler a : ficha.getAlquileresVigentes()
                     ) {
                    if(0<a.calcularRecargo(new GregorianCalendar())){
                        System.out.println("Este socio tiene recargos pendientes , debe abonar " + a.calcularRecargo(new GregorianCalendar()));
                    }
                }
            }
        }
        boolean encontrado=false;

        do {
            System.out.println("Dime el id del alquilable");
            int idAlquilable = 0;
            try {
                idAlquilable = Integer.parseInt(lector.nextLine());
                for (Alquilable a : videoclub.getAlquilables()
                ) {
                    if (idAlquilable == a.getId()) {
                        boolean correcto;
                        System.out.println("Este es su alquilable");
                        encontrado=true;
                        System.out.println(a.toString());
                        Lib.pausa();
                        correcto=videoclub.alquilar(a, socio1);
                        if(correcto){
                            System.out.println("Alquilado con exito");
                            Lib.pausa();
                            Lib.limpiarPantalla();
                        }else{
                            System.out.println("Error al alquilar");
                        }

                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Introduce un numero por favor");
                Lib.pausa();
            }
            if(!encontrado){
                System.out.println("El alquilable no existe, introduzca otro");
                Lib.pausa();
            }
        }while (!encontrado);
    }

    public static void devolver(){
        int id=0;
        do {
            System.out.println("Dime el id del alquilable");
            try {
                id = Integer.parseInt(lector.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("Introduce un numero");
            }
        }while (id==0);

        if(id>0){
            for (FichaSocio ficha: videoclub.getFichasSocios()
            ) {
                for (Alquiler a:ficha.getAlquileresVigentes()
                ) {
                    if (a.getAlquilable().getId()==id){

                        if(videoclub.devolverAlquilable(a.getAlquilable())){

                            System.out.println(ficha.getSocio().toString());
                            System.out.println(a.getAlquilable().toString());
                            System.out.println("El recargo es: " + a.calcularRecargo(new GregorianCalendar()));
                            Lib.pausa();
                            System.out.println("Devuelto con exito");

                            Lib.pausa();
                            return ;
                        }
                    }
                }
            }
        }
        System.out.println("No encontrado");
        Lib.pausa();
    }

    public static void anyadirMultimedia(){



    }
}





