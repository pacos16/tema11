package com.pacosignes.tema11.ex6;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Videoclub {

    public static final int DESCUENTO_ANYO_PELICULAS=2012;
    public static final int DESCUENTO_ANYO_VIDEOJUEGOS=2010;
    public static final int PERIODO_ALQUILER=3;
    public static final float PRECIO_BASE=4;
    public static final float RECARGO_POR_DIA=2;



    private ArrayList<Multimedia> multimedia=new ArrayList<>(100);
    private ArrayList<Alquilable> alquilables=new ArrayList<>(100);
    private ArrayList<Socio> socios=new ArrayList<>(100);
    private ArrayList<FichaSocio> fichasSocios=new ArrayList<>(100);
    private ArrayList<Multimedia> multimediaBorrados=new ArrayList<>(100);
    private ArrayList<Alquilable> alquilablesBorrados=new ArrayList<>(100);

    public void anyadirMultimedia(Multimedia multi){
        multimedia.add(multi);

    }

    public void anyadirAlquilable(Alquilable alquilable){
        alquilables.add(alquilable);
    }

    public void anyadirSocio(Socio socio){
        socios.add(socio);
    }

    private void anyadirFichaSocio(FichaSocio fichaSocio){
        fichasSocios.add(fichaSocio);
    }



    public boolean borrarMultimedia(Multimedia multimedia){

        // cuatro bucles papi
        for (Alquilable a:alquilables
             ) {
            if(a.getMultimedia().equals(multimedia)){
                alquilablesBorrados.add(a);
                for (FichaSocio ficha: fichasSocios
                     ) {
                    for (Alquiler alquiler:ficha.getAlquileresVigentes()
                         ) {
                        if(alquiler.getAlquilable().equals(a)){
                            return false;
                        }
                    }

                    for (Alquiler alquiler: ficha.getAlquileres()
                         ) {
                        if(alquiler.getAlquilable().equals(a)){
                            for (Alquilable alquilable:alquilablesBorrados
                                 ) {
                                if(alquiler.getAlquilable().equals(alquilable)){
                                    alquiler.setAlquilable(alquilable);
                                }
                            }
                        }
                    }
                }
                alquilables.remove(a);
            }
        }

        for (Multimedia m:this.multimedia
             ) {
            if(m.equals(multimedia)){
                multimediaBorrados.add(multimedia);
                this.multimedia.remove(multimedia);
                return true;
            }
        }
        return false;
    }

    public boolean borrarAlquilable(Alquilable alquilable){

        for (Alquilable a:alquilables
             ) {

            if(a.equals(alquilable)){
                alquilablesBorrados.add(alquilable);
                alquilables.remove(alquilable);
                return true;
            }
        }
        return false;
    }

    /**
     * Funcion de alquiler. Anyade alquiler a ficha cliente
     * @param alquilable
     * @param socio
     * @return devuelve false en caso de no completar la tarea
     */
    public boolean alquilar(Alquilable alquilable, Socio socio){
        boolean disponible= false;
        //comprueba que existe el atriculo
        for (Alquilable a:alquilables
             ) {
            if(a.equals(alquilable)){
                disponible=true;
            }
        }
        //si no existe sale
        if(!disponible){
            return false;
        }


        //comprueba que el articulo no esta actualmente alquilado
        for (FichaSocio ficha: fichasSocios
             ) {
            for (Alquiler alquiler:ficha.getAlquileresVigentes()
                 ) {
                if (alquilable.equals(alquiler.getAlquilable())){
                    return false;
                }
            }
        }
        //Busca en la base de datos si hay una ficha con ese socio y le anyade el alquiler
        for (FichaSocio f: fichasSocios
             ) {
            if(f.getSocio().equals(socio)){
                f.addAlquiler(new Alquiler(alquilable, new GregorianCalendar()));
                return true;
            }
        }
        //Si no lo encuentra crea una nueva ficha socio y le introduce el alquiler
        anyadirFichaSocio(new FichaSocio(socio));
        for (FichaSocio f: fichasSocios
        ) {
            if(f.getSocio().equals(socio)){
                f.addAlquiler(new Alquiler(alquilable, new GregorianCalendar()));
                return true;
            }
        }

        return false;
    }

    /**
     * Devuelve alquilable si no lo consigue devuelve false
     * @param alquilable
     * @return
     */
    public boolean devolverAlquilable(Alquilable alquilable){

        for (FichaSocio fichaSocio:fichasSocios
             ) {
            for (Alquiler alquiler:fichaSocio.getAlquileresVigentes()){
                if(alquiler.getAlquilable().equals(alquilable)){
                    alquiler.setFechaDevolucion(new GregorianCalendar());
                    fichaSocio.devolverAlquilable(alquilable);
                    return true;
                }
            }
        }

        return false;
    }
    public boolean devolverAlquilable(Alquilable alquilable,GregorianCalendar fechaDevolucion){

        for (FichaSocio fichaSocio:fichasSocios
        ) {
            for (Alquiler alquiler:fichaSocio.getAlquileresVigentes()){
                if(alquiler.getAlquilable().equals(alquilable)){
                    alquiler.setFechaDevolucion(fechaDevolucion);
                    fichaSocio.devolverAlquilable(alquilable);
                    return true;
                }
            }
        }

        return false;
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public ArrayList<Alquilable> getAlquilables() {
        return alquilables;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public ArrayList<FichaSocio> getFichasSocios() {
        return fichasSocios;
    }

    public ArrayList<Multimedia> getMultimediaBorrados() {
        return multimediaBorrados;
    }

    public ArrayList<Alquilable> getAlquilablesBorrados() {
        return alquilablesBorrados;
    }
}
