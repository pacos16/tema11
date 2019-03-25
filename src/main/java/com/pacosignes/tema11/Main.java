package com.pacosignes.tema11;

import com.pacosignes.tema11.ex1.Punto;
import com.pacosignes.tema11.ex2.Poligono;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<Punto> puntos=new ArrayList<>();

        puntos.add(new Punto(0,0));
        puntos.add(new Punto(2,0));
        puntos.add(new Punto(2,2));
        puntos.add(new Punto(0,2));


        Poligono p=new Poligono(puntos);
        System.out.println(p.toString());
        System.out.println(p.perimetro());
        p.desplazar(4,-3);
        System.out.println(p.perimetro());
        System.out.println(p.toString());
    }
}
