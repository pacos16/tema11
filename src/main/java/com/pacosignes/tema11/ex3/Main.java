package com.pacosignes.tema11.ex3;

public class Main {

    public static void main(String[] args) {


        Coche c=new Automatico();
        Coche c1=new Manual();

        c1.acelerar(25);
        c1.imprimirVelocidad();

        System.out.println(c1.getMarcha());

        ((Manual) c1).cambiarMarcha(5);
        System.out.println(c1.getMarcha());

        c.cambiarMarcha();
        c.acelerar(25);
        System.out.println(c.getMarcha());
        c.acelerar(2);
        c.frenar(40);
        System.out.println(c.getMarcha());
        c.imprimirVelocidad();
    }
}
