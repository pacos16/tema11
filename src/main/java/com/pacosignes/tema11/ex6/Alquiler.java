package com.pacosignes.tema11.ex6;

import java.util.GregorianCalendar;

public class Alquiler {

    private Alquilable alquilable;
    private GregorianCalendar fechaAlquiler;

    private GregorianCalendar fechaDevolucion;
    private float profit;

    public Alquiler(Alquilable alquilable, GregorianCalendar fechaAlquiler) {
        this.alquilable = alquilable;
        this.fechaAlquiler = fechaAlquiler;
        fechaDevolucion=null;
        profit=0;
    }

}
