package com.pacosignes.tema11.ex3;


public class Manual extends Coche {


    public Manual(String matricula){
        super(matricula);
        marcha=Marchas.PARQUING;
    }

    public void cambiarMarcha(int march){

        for (Marchas m: Marchas.values()
             ) {
            if(m.getNum()==march){
                marcha=m;
            }
        }
    }
}
