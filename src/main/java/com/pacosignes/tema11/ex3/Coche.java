package com.pacosignes.tema11.ex3;

public abstract class Coche {
    protected double velocidad;
    protected String matricula;
    protected Marchas marcha;

    public Coche(){

    }

    protected  void cambiarMarcha(){

    }

    public double getVelocidad() {
        return velocidad;
    }
    public String getMarcha(){
        return marcha.toString();
    }
    public void acelerar(double a){
        velocidad+=a;
    }
    public void frenar(double a){
        velocidad-=a;
        if(velocidad<0){
            velocidad=0;
        }
    }

    public void imprimirVelocidad(){
        System.out.println("Su velocidad es de "+velocidad+"Km/h");
    }



}
