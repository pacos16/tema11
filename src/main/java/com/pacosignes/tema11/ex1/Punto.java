package com.pacosignes.tema11.ex1;

public class Punto {


    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(){

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia(Punto p){

        return Math.sqrt((Math.pow(this.x-p.getX(),2)+Math.pow(this.y-p.getY(),2)));

    }

    @Override
    public String toString() {
        return "Punto("
                + x +
                ","
                + y +
                ')';
    }


}
