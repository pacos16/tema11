package com.pacosignes.tema11.ex4;

public class Electrodomestico {
    //enum y String
    public enum Colores{
        BLANCO("blanco"),NEGRO("negro"),ROJO("rojo"),AZUL("azul"),GRIS("gris");
        String nombre;
        private Colores(String nombre){
            this.nombre=nombre;
        }

        public String getNombre(){
            return nombre;
        }

    }
    protected static final String ETIQUETAS_EFI="ABCDEF";

    //valores por defecto
    protected static final double PESO_DEF=5;
    protected static final double PRECIO_DEF=100;
    protected static final char EFI_DEF='F';
    protected static final Colores COLOR_DEF=Colores.BLANCO;


    protected double precioBase;
    protected double peso;
    protected Colores color;
    protected char eficienciaEnergetica;

    public Electrodomestico() {
        precioBase=Electrodomestico.PRECIO_DEF;
        peso=Electrodomestico.PESO_DEF;
        color=Electrodomestico.COLOR_DEF;
        eficienciaEnergetica=Electrodomestico.EFI_DEF;

    }

    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        color=Electrodomestico.COLOR_DEF;
        eficienciaEnergetica=Electrodomestico.EFI_DEF;
    }

    public Electrodomestico(double precioBase, double peso, String color, char eficienciaEnergetica) {
        this.precioBase = precioBase;
        this.peso = peso;
        comprobarColor(color);
        this.eficienciaEnergetica = eficienciaEnergetica;
    }


    private void comprobarColor(String color){
        boolean correcto=false;
        for (Colores c: Colores.values()
             ) {
            String colorAux=color.toLowerCase();
            if(color.equals(c.getNombre())){
                this.color=c;
                correcto=true;
            }
        }
        if(!correcto){
            this.color=Electrodomestico.COLOR_DEF;
        }

    }


}