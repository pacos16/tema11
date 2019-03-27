package com.pacosignes.tema11.ex3;

public class Automatico extends Coche {

    public Automatico(String matricula){
        super(matricula);
        marcha=Marchas.PARQUING;

    }

    @Override
    public void acelerar(double a) {
        super.acelerar(a);
        cambiarMarcha();
    }

    @Override
    public void frenar(double a) {
        super.frenar(a);
        cambiarMarcha();
    }

    public void cambiarMarcha(){

        if (velocidad>=80){
            marcha= Marchas.QUINTA;
        }else if(velocidad>=60){
            marcha=Marchas.QUARTA;
        }else if(velocidad>=35){
            marcha= Marchas.TERCERA;
        }else if(velocidad>=20){
            marcha= Marchas.SEGUNDA;
        }else if(velocidad>0){
            marcha= Marchas.PRIMERA;
        }else{
            marcha=Marchas.PARQUING;
        }

    }
}
