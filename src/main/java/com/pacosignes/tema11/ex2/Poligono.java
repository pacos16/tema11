package com.pacosignes.tema11.ex2;


import com.pacosignes.tema11.ex1.Punto;

import java.util.ArrayList;

public class Poligono {

    ArrayList<Punto> puntos =new ArrayList<>(3);

    public Poligono(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public void desplazar(double x, double y){
        for (Punto p:puntos
             ) {
            p.setX(p.getX()+x);
            p.setY(p.getY()+y);
        }
    }

    public int numVertices(){
        if(puntos.size()>=3){
            return puntos.size();
        }else{
            return 0;
        }

    }

    public double perimetro(){
        double perimetro=0;

        if(puntos.size()>=3){

            for(int i =0;i<puntos.size();i++){
                if(i==puntos.size()-1){
                    perimetro+=puntos.get(i).distancia(puntos.get(0));

                }else {
                    perimetro += puntos.get(i).distancia(puntos.get(i + 1));
                }
            }

        }
        return perimetro;

    }

    @Override
    public String toString() {

        StringBuilder s=new StringBuilder();
        for (Punto p: puntos
             ) {
            s.append(p.toString());
            s.append("\n");
        }
        return "Poligono:\n"+s;
    }
}
