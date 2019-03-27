package com.pacosignes.tema11.ex3;

public enum Marchas {

    PARQUING("Parquing",0), PRIMERA("Primera" ,1), SEGUNDA("Segunda",2)
    , TERCERA("Tercera",3), QUARTA("Cuarta",4), QUINTA("Quinta",5);

    private int num;
    private String nombre;

    private Marchas(String nombre,int numero){
        this.nombre=nombre;
        this.num=numero;
    }

    @Override
    public String toString() {
        return "Usted esta en "+nombre;
    }

    public int getNum() {
        return num;
    }

    public String getNombre() {
        return nombre;
    }
}