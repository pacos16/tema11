package com.pacosignes.tema11.ex6;



import com.github.javafaker.Faker;
import com.pacosignes.tema11.Lib;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;


public class Main {

    static Videoclub videoclub=new Videoclub();
    static Scanner lector=new Scanner(System.in);


    public static void main(String[] args) {
        Faker faker=new Faker(new Locale("es"));
        ArrayList<Multimedia.Formato> formatos=new ArrayList<>();
        ArrayList<Videojuego.Plataforma> plataformas=new ArrayList<>();
        formatos.add(Multimedia.Formato.ARCHIVO);
        formatos.add(Multimedia.Formato.BLUE_RAY);
        formatos.add(Multimedia.Formato.DVD);
        plataformas.add(Videojuego.Plataforma.PS4);
        plataformas.add(Videojuego.Plataforma.PS3);
        plataformas.add(Videojuego.Plataforma.NINTENDO_Switch);
        //faker para socios
        videoclub.anyadirSocio(new Socio("German","Gascon", Lib.gregorianFromString("15/10/1985")));
        for(int i=0;i<100;i++){

            videoclub.anyadirSocio(new Socio(faker.name().firstName(),faker.name().lastName(),
                    Lib.fakerFechas("05/10/1992","08/10/2000")));
        }
        //faker para multimedia
        videoclub.anyadirMultimedia(new Pelicula("Superman","Richard Donner",
                Lib.gregorianFromString("10/10/1978"),143,"Genne Hackman",
                "Marlon Brando", Pelicula.Genero.ACCION,formatos));
        for(int i=0;i<100;i++){
            videoclub.anyadirMultimedia(new Pelicula(faker.harryPotter().book(),faker.artist().name(),
                    Lib.fakerFechas("05/10/1994","08/10/2018"),faker.number().randomDigit(),faker.name().firstName(),
                    faker.name().firstName(), Pelicula.Genero.ACCION,formatos ));

            videoclub.anyadirMultimedia(new Videojuego(faker.lordOfTheRings().character(),faker.artist().name(),
                    Lib.fakerFechas("05/10/1994","08/10/2018"),plataformas,formatos));
        }



        for (Multimedia m:videoclub.getMultimedia()
             ) {
            for (Multimedia.Formato formato: m.getFormatos()
                 ) {
                if(m instanceof  Pelicula) videoclub.anyadirAlquilable(new Alquilable((Pelicula)m,formato));
                if(m instanceof Videojuego){
                    for (Videojuego.Plataforma plataforma:Videojuego.Plataforma.values()
                         ) {
                        videoclub.anyadirAlquilable(new Alquilable((Videojuego)m,formato,plataforma));
                    }

                }
            }
        }
        Collections.sort(videoclub.getMultimedia());

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
                                    anyadirMultimedia();
                                } else if (opcion2 == 2) {
                                    //todo borrarMultimedia();
                                }
                            }
                        } catch (NumberFormatException nfe) {
                            System.out.println("Introduce un numero porfavor");
                        }
                    }while(opcion2 < 0 || opcion2 > 2);
                    break;
                case 3:
                    int opcion3=-1;
                    do {
                        System.out.println("SOCIOS");
                        System.out.println("----------");
                        System.out.println("1.Anyadir");
                        System.out.println("2.Listado");
                        System.out.println("--------");
                        System.out.println("0.Volver");
                        try {
                            opcion3 = Integer.parseInt(lector.nextLine());
                            if (opcion3 < 0 || opcion3 > 2) {
                                System.out.println("Introduce un numero de la lista");
                            } else {
                                if (opcion3 == 1) {
                                    anyadirSocio();
                                }else if(opcion3==2){
                                    for (Socio socio:videoclub.getSocios()
                                         ) {
                                        System.out.println(socio.toString());
                                    }
                                }
                            }
                        }catch (NumberFormatException nfe) {
                            System.out.println("Introduce un numero porfavor");
                        }
                    }while(opcion3!=0);
                    break;
                case 4:
                    int opcion4;
                    do{
                        System.out.println("INFORMES");
                        System.out.println("--------");
                        System.out.println("1.Todos los Multimedia");
                        System.out.println("2.Todos los Alquilables");
                        System.out.println("3.Peliculas por titulo");
                        System.out.println("4.Videojuegos por anyo");
                        System.out.println("5.Historicos de alquiler de socio");
                        System.out.println("6.Listado de socios con recargo pendiente");
                        System.out.println("7.Alquileres vigentes");
                        System.out.println("--------------------------------");
                        System.out.println("0.Volver");
                        opcion4=Lib.pedirInt(0,7);
                        //todo pasar metodos a videoclub??
                        switch (opcion4){
                            case 1:
                                //ordena por nombre
                                Collections.sort(videoclub.getMultimedia());
                                //imprime multimedia
                                for (Multimedia multimedia:videoclub.getMultimedia()
                                     ) {
                                    System.out.println(multimedia.toString());
                                }
                                Lib.pausa();
                                break;
                            case 2:
                                //ordena alqulables por nombre
                                videoclub.getAlquilables().sort(new Alquilable.ComparatorNombre());
                                //imprime
                                for (Alquilable alquilable: videoclub.getAlquilables()
                                     ) {
                                    System.out.println(alquilable.toString());
                                }
                                Lib.pausa();
                                break;
                            case 3:
                                //ordena multimedia por nombre
                                Collections.sort(videoclub.getMultimedia());
                                //imprime peliculas
                                for (Multimedia multimedia:videoclub.getMultimedia()
                                ) {
                                    if( multimedia instanceof Pelicula) {
                                        System.out.println(multimedia.toString());
                                    }
                                }
                                Lib.pausa();
                                break;
                            case 4:
                                //ordena por fecha
                                videoclub.getMultimedia().sort(new Multimedia.ComparatorFecha());
                                //imprime Videojuegos
                                for (Multimedia multimedia:videoclub.getMultimedia()
                                ) {
                                    if( multimedia instanceof Videojuego) {
                                        System.out.println(multimedia.toString());
                                    }
                                }
                                Lib.pausa();
                                break;
                            case 5:

                                for (FichaSocio ficha:videoclub.getFichasSocios()
                                     ) {
                                    System.out.println(ficha.getSocio().toString());
                                    System.out.println(ficha.getAlquileres().toString());
                                }
                                Lib.pausa();
                                break;
                            case 6:
                                int recargo=0;
                                for (FichaSocio ficha: videoclub.getFichasSocios()
                                     ) {
                                    for (Alquiler alquiler:ficha.getAlquileresVigentes()
                                         ) {
                                        recargo+=alquiler.calcularRecargo(new GregorianCalendar());
                                    }
                                    if(recargo>0){
                                        System.out.println(ficha.getSocio().toString());
                                        for (Alquiler alquiler: ficha.getAlquileres()
                                             ) {
                                            if(alquiler.calcularRecargo(new GregorianCalendar())>0){
                                                System.out.println(alquiler.toString()+
                                                        " Recargo: "+alquiler.calcularRecargo(new GregorianCalendar()));
                                            }
                                        }
                                    }

                                }
                                Lib.pausa();
                                break;
                            case 7:
                                for (FichaSocio ficha:videoclub.getFichasSocios()
                                     ) {
                                    if(ficha.getAlquileresVigentes().size()>0){
                                        System.out.println(ficha.getSocio().toString());
                                        System.out.print(" ");
                                        System.out.println(ficha.getAlquileresVigentes().toString());
                                    }
                                }
                                Lib.pausa();
                                break;
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
            boolean numero;

            do {

                numero=false;
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
                        System.out.println("Este socio tiene recargos pendientes , debe abonar "
                                + a.calcularRecargo(new GregorianCalendar()));
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
                            Lib.pausa();
                            Lib.limpiarPantalla();
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
        int opcion;
        do{
            System.out.println("Elige una opcion");
            System.out.println("1.Pelicula");
            System.out.println("2.Videojuego");
            System.out.println("------------");
            System.out.println("0.Volver");
            opcion=Lib.pedirInt(0,2);


            int opcion2=0;
            if(opcion==1) {
                do {
                    System.out.println("1.Nueva pelicula");
                    System.out.println("2.Alquilable desde pelicula ");
                    System.out.println("---------------------");
                    System.out.println("0.Volver");
                    opcion2 = Lib.pedirInt(0, 2);

                    if (opcion2 == 1) {
                        anyadirPelicula();
                    }else if(opcion2==2){
                        String titulo;
                        String autor;
                        boolean encontrada;
                        Pelicula p=null;
                        do{
                            encontrada=false;
                            System.out.println("**Introduzca los datos de la pelicula**");
                            System.out.println("Dime el titulo");
                            titulo= lector.nextLine();
                            System.out.println("Dime el autor");
                            autor= lector.nextLine();
                            for (Multimedia multimedia: videoclub.getMultimedia()
                                 ) {
                                if(multimedia.getNombre().toLowerCase().equals(titulo) &&
                                multimedia.getAutor().toLowerCase().equals(autor) && multimedia instanceof Pelicula){
                                    encontrada=true;
                                    p=(Pelicula)multimedia;
                                }
                            }
                            if(!encontrada){
                                System.out.println("Esta pelicula no esta en la base de datos");
                                Lib.pausa();
                            }
                        }while(!encontrada);
                        boolean disponible;
                        int opcionFormato;
                        do{
                            disponible=false;
                            System.out.println("*Elige un formato*");
                            opcionFormato=seleccionarFormato();
                            for (Multimedia.Formato formato :p.formatos
                                 ) {
                                if(formato.ordinal()==opcionFormato-1){
                                    disponible=true;
                                    videoclub.getAlquilables().add(new Alquilable(p,formato));
                                    System.out.println("Alquilable anyadido con exito");
                                }
                            }
                            if(!disponible){
                                System.out.println("Este formato no esta disponible");
                                Lib.pausa();
                            }
                        }while (!disponible);
                    }

                } while (opcion2 != 0);


            }else if(opcion==2){
                int opcion3;
                System.out.println("*Videojuegos*");
                System.out.println("1.Anyadir videojuego");
                System.out.println("2.Anyadir alquilable videojuego");
                System.out.println("--------------------");
                System.out.println("0.Volver");
                opcion3=Lib.pedirInt(0,2);
                if(opcion3==1) {
                    anyadirVideojuego();
                }else if(opcion3==2){
                    String titulo;
                    String autor;
                    boolean encontrada;
                    Videojuego v=null;
                    do{
                        encontrada=false;
                        System.out.println("**Introduzca los datos del videojuego**");
                        System.out.println("Dime el titulo");
                        titulo= lector.nextLine();
                        System.out.println("Dime el autor");
                        autor= lector.nextLine();
                        for (Multimedia multimedia: videoclub.getMultimedia()
                        ) {
                            if(multimedia.getNombre().toLowerCase().equals(titulo) &&
                                    multimedia.getAutor().toLowerCase().equals(autor) && multimedia instanceof Videojuego){
                                encontrada=true;
                                v=(Videojuego)multimedia;
                            }
                        }
                        if(!encontrada){
                            System.out.println("Este videojuego no esta en la base de datos");
                            Lib.pausa();
                        }
                    }while(!encontrada);
                    boolean disponible;
                    int opcionFormato;
                    Multimedia.Formato format=null;
                    do{
                        disponible=false;
                        System.out.println("*Elige un formato*");
                        opcionFormato=seleccionarFormato();
                        for (Multimedia.Formato formato :v.formatos
                        ) {
                            if(formato.ordinal()==opcionFormato-1){
                                disponible=true;
                                format=formato;
                                System.out.println("Formato anyadido con exito");
                            }
                        }
                        if(!disponible){
                            System.out.println("Este formato no esta disponible");
                            Lib.pausa();
                        }
                    }while (!disponible);
                    int opcionPlataforma;
                    do{
                        disponible=false;
                        System.out.println("*Elige una plataforma*");
                        opcionPlataforma=seleccionarPlataforma();
                        for (Videojuego.Plataforma plat:Videojuego.Plataforma.values()
                             ) {
                            if(plat.ordinal()==opcionPlataforma-1){
                                disponible=true;
                                videoclub.getAlquilables().add(new Alquilable(v,format,plat));
                                System.out.println("Videojuego creado con exito");
                            }
                        }
                    }while(!disponible);
                }
            }
        }while(opcion!=0);

    }

    public static void anyadirPelicula(){
        String nombre;
        String autor;
        GregorianCalendar fechaEstreno=new GregorianCalendar();
        int duracion;
        String actriz;
        String actor;
        Pelicula.Genero genero;
        ArrayList<Multimedia.Formato> formatos=new ArrayList<>();

        do{
            System.out.println("Dime el titulo");
            nombre= lector.nextLine();

        }while (nombre.length()<1);
        do{
            System.out.println("Dime el autor");
            autor= lector.nextLine();

        }while (autor.length()<1);
        String fecha;
        do{
            System.out.println("Dime una fecha de estreno en formato dd/mm/yyyy");
            fecha= lector.nextLine();
            if(Lib.validarFecha(fecha)){
                fechaEstreno=Lib.gregorianFromString(fecha);
            }
            if(!Lib.validarFecha(fecha)){
                System.out.println("La fecha no es valida");
            }

        }while (!Lib.validarFecha(fecha));
        int opcion;


        System.out.println("Dime la duracion");
        duracion= Lib.pedirInt(1,1000);
        do{
            System.out.println("Dime la actriz principal");
            actriz= lector.nextLine();

        }while (actriz.length()<1);
        do{
            System.out.println("Dime el actor principal");
            actor= lector.nextLine();

        }while (actor.length()<1);


         System.out.println("Genero");
         for (Pelicula.Genero g: Pelicula.Genero.values()
                 ) {
             System.out.println(g.ordinal()+" "+g.toString());
         }
         opcion=Lib.pedirInt(0, Pelicula.Genero.values().length-1);

         genero= Pelicula.Genero.values()[opcion];
         int opcion2;
         do{
             opcion2=seleccionarFormato();
             if(opcion2!=0){
                 boolean noEsta=true;
                 for (Multimedia.Formato format:formatos
                 ) {
                     if(format.equals(Multimedia.Formato.values()[opcion2-1])){
                         noEsta=false;
                         System.out.println("Este formato ya esta");
                     }
                 }
                 if(noEsta){
                     formatos.add(Multimedia.Formato.values()[opcion2-1]);
                 }
             }


         }while(opcion2!=0 || formatos.size()==0);

         videoclub.getMultimedia().add(new Pelicula(nombre,autor,fechaEstreno,duracion,actriz,actor,genero,formatos));
        System.out.println("Pelicula creada con exito");
        Lib.pausa();
    }

    /**
     * Devuelve el formato con su numero integer no con su numero ordinal, para ello le restaremos uno luego
     * @return
     */
    public static int seleccionarFormato(){

        for (Multimedia.Formato f: Multimedia.Formato.values()
        ) {
            System.out.println(f.getPosicion()+" "+f.toString());
        }
        System.out.println("--------------");
        System.out.println("0. Para continuar");
        return Lib.pedirInt(0,Multimedia.Formato.values().length);
    }
    public static int seleccionarPlataforma(){

        for (Videojuego.Plataforma p: Videojuego.Plataforma.values()
        ) {
            System.out.println((p.ordinal()+1)+" "+p.toString());
        }
        System.out.println("--------------");
        System.out.println("0. Para continuar");
        return Lib.pedirInt(0,Multimedia.Formato.values().length);
    }
    public static void anyadirVideojuego(){
        String nombre;
        String autor;
        GregorianCalendar fechaEstreno=new GregorianCalendar();
        ArrayList<Videojuego.Plataforma> plataformas=new ArrayList<>();
        ArrayList<Multimedia.Formato> formatos=new ArrayList<>();

        do{
            System.out.println("Dime el nombre");
            nombre= lector.nextLine();

        }while (nombre.length()<1);
        do{
            System.out.println("Dime el autor");
            autor= lector.nextLine();

        }while (autor.length()<1);
        String fecha;
        do{
            System.out.println("Dime una fecha de estreno en formato dd/mm/yyyy");
            fecha= lector.nextLine();
            if(Lib.validarFecha(fecha)){
                fechaEstreno=Lib.gregorianFromString(fecha);
            }
            if(!Lib.validarFecha(fecha)){
                System.out.println("La fecha no es valida");
            }

        }while (!Lib.validarFecha(fecha));

        int opcion2;
        do{
            opcion2=seleccionarFormato();
            if(opcion2!=0){
                boolean noEsta=true;
                for (Multimedia.Formato format:formatos
                ) {
                    if(format.equals(Multimedia.Formato.values()[opcion2-1])){
                        noEsta=false;
                        System.out.println("Este formato ya esta");
                    }
                }
                if(noEsta){
                    formatos.add(Multimedia.Formato.values()[opcion2-1]);
                }
            }


        }while(opcion2!=0 || formatos.size()==0);
        int opcion;
        do{
            opcion=seleccionarPlataforma();
            if(opcion!=0){
                boolean noEsta=true;
                for (Videojuego.Plataforma p: plataformas
                     ) {
                    if(p.equals(Videojuego.Plataforma.values()[opcion-1])){
                        noEsta=false;
                        System.out.println("Esta plataforma ya esta");
                    }
                }
                if(noEsta){
                    plataformas.add(Videojuego.Plataforma.values()[opcion-1]);
                }

            }
        }while(opcion!=0 || plataformas.size()==0);
        videoclub.anyadirMultimedia(new Videojuego(nombre,autor,fechaEstreno,plataformas,formatos));
        System.out.println("Videojuego creado con exito creada con exito");
        Lib.pausa();
    }

    public static void anyadirSocio(){
        String nombre;
        String apellido;
        GregorianCalendar fechaNacimiento;
        do{
            System.out.println("Dime un nombre");
            nombre= lector.nextLine();
        }while (nombre.length()<1);
        do{
            System.out.println("Dime un apellido");
            apellido= lector.nextLine();
        }while (apellido.length()<1);
        String fechaString;
        int edad;
        do {
            do {
                System.out.println("Dime una fecha de nacimiento");
                fechaString = lector.nextLine();
                if(!Lib.validarFecha(fechaString)){
                    System.out.println("La fecha no es correcta");
                    Lib.pausa();
                }
            } while (!Lib.validarFecha(fechaString));
            fechaNacimiento=Lib.gregorianFromString(fechaString);
            Date current=new GregorianCalendar().getTime();
            LocalDate currentLocal= current.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaNacLocal= fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            edad=Period.between(currentLocal,fechaNacLocal).getYears();
            if(edad<18){
                System.out.println("Se necesita se mayor de edad");
                Lib.pausa();
            }
        }while(edad<18);
        videoclub.anyadirSocio(new Socio(nombre,apellido,fechaNacimiento));
        System.out.println("Socio anyadido con exito");
        Lib.pausa();
    }


}






