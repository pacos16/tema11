package com.pacosignes.tema11.ex4;

public class Lavadora extends Electrodomestico{

    private double carga;

    public static final double CARGA_DEF= 5;

    public Lavadora() {
        super();
        carga=CARGA_DEF;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        carga=CARGA_DEF;
    }

    public Lavadora(double precioBase, double peso, String color, char eficienciaEnergetica, double carga) {
        super(precioBase, peso, color, eficienciaEnergetica);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        if(carga<30) {
            return super.precioFinal();
        }else{
            return super.precioFinal()+50;
        }
    }
}
