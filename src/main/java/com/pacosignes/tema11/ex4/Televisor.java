package com.pacosignes.tema11.ex4;

public class Televisor extends Electrodomestico {

    private boolean smartTV;
    private double pulgadas;
    public static final double PULGADAS_DEF=20;
    public Televisor() {
        super();
        smartTV=false;
        pulgadas=Televisor.PULGADAS_DEF;
    }

    public Televisor(double precioBase, double peso) {
        super(precioBase, peso);
        smartTV=false;
        pulgadas=Televisor.PULGADAS_DEF;
    }

    public Televisor(double precioBase, double peso, String color, char eficienciaEnergetica, boolean smartTV, double pulgadas) {
        super(precioBase, peso, color, eficienciaEnergetica);
        this.smartTV = smartTV;
        this.pulgadas = pulgadas;
    }


    public boolean isSmartTV() {
        return smartTV;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    @Override
    public double precioFinal() {

        double precio= super.precioFinal();

        if(pulgadas>=40){
            precio+=precio*0.3;
        }
        if(smartTV){
            precio+=50;
        }

        return precio;
    }
}
