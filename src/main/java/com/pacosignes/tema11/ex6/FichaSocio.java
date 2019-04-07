package com.pacosignes.tema11.ex6;

import java.util.ArrayList;

public class FichaSocio {


    private Socio socio;
    private ArrayList<Alquiler> alquileres=new ArrayList<>();
    private ArrayList<Alquiler> alquileresVigentes=new ArrayList<>();

    public FichaSocio(Socio socio) {
        this.socio = socio;
    }
    public void addAlquiler(Alquiler alquiler){
        alquileresVigentes.add(alquiler);
    }

    public Socio getSocio() {
        return socio;
    }

    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }

    public ArrayList<Alquiler> getAlquileresVigentes() {
        return alquileresVigentes;
    }
}
