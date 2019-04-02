package com.pacosignes.tema11.ex5;

import java.util.Scanner;

public class Inventario {

    static Scanner lector=new Scanner (System.in);



    private Slot[] inventario;


    public Inventario(int numSlots) {
        this.inventario = new Slot[numSlots];

        for(int i=0;i<numSlots;i++){
            inventario[i]=new Slot();
        }
    }



    public int addItem(Item item, int cantidad){

            for(int i=0;i<inventario.length;i++){
                if(inventario[i].getItem().getClass().equals(item.getClass())){

                    cantidad=inventario[i].stackItem(cantidad);
                }
            }
            if(cantidad>0){
                for(int i=0;i<inventario.length && cantidad>0;i++){
                    if(inventario[i].getVacio()){
                        inventario[i].setItem(item);
                        cantidad=inventario[i].stackItem(cantidad);
                    }
                }
            }

        return cantidad;
    }





    public void printInventario(){
        for (Slot s: inventario
             ) {
            System.out.println(s.toString());
        }
    }





}
