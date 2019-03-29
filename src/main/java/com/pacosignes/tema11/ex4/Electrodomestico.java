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
    //todo enum con cosas.
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
        comprobarConsumoEnergetico(eficienciaEnergetica);
    }

    private void comprobarConsumoEnergetico(char consumo){
        boolean correcto=false;
        for(int i = 0; i<Electrodomestico.ETIQUETAS_EFI.length();i++){
            if(consumo==Electrodomestico.ETIQUETAS_EFI.charAt(i)){
                eficienciaEnergetica=consumo;
                correcto=true;
            }
        }
        if(!correcto){
            eficienciaEnergetica=Electrodomestico.EFI_DEF;
        }
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

    public double precioFinal(){
        int[] pesos={20,50,80};
        double precioFinal;

        if(peso<pesos[0]){
            precioFinal=precioBase+10;
        }else if(peso<pesos[1]){
            precioFinal=precioBase+50;
        }else if(peso<pesos[2]){
            precioFinal=precioBase+80;
        }else{

            precioFinal=precioBase+100;
        }


        switch (eficienciaEnergetica){

            case 'A':precioFinal+=100;
            break;
            case 'B': precioFinal+=80;
            break;
            case 'C': precioFinal+=60;
            break;
            case 'D': precioFinal+=50;
            break;
            case 'E': precioFinal+=30;
            break;
            case 'F': precioFinal+=10;
            break;

        }
        return precioFinal;
    }




}
