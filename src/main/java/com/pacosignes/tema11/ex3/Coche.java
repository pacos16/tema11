package com.pacosignes.tema11.ex3;

abstract class Coche {
    double velocidad;
    String matricula;
    Marchas marcha;

    abstract boolean cambiarMarcha();

    public double getVelocidad() {
        return velocidad;
    }
    public String getMarcha(){
        return marcha.toString();
    }

}
