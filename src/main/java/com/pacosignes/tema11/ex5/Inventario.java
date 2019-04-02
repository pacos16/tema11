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



    public int addItem(){
        int opcion;
        Item item=new Item();
        do{

            menuItems();
            try {
                opcion = Integer.parseInt(lector.nextLine());
            }catch (NumberFormatException nfe){
                opcion =-1;
            }
            if(opcion<0 || opcion>5){
                System.out.println("No correcto repita");
            }
        }while(opcion<0 || opcion>5);

        switch (opcion){
            case 1:
                item=new Pico();
            break;

        }
        boolean correcto;
        int cantidad=0;
        do {
            correcto=true;
            System.out.println("quantos quieres anyadir");
            try {
                cantidad = Integer.parseInt(lector.nextLine());
            }catch (NumberFormatException nfe){
                System.out.println("Caracter no correcto");
                correcto=false;
            }
        }while(!correcto);



        while(cantidad>0){
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
        }
        return cantidad;
    }



    private void menuItems(){

        System.out.println("Dime que item quieres anyadir");
        System.out.println("1. Pico");
        System.out.println("2. Espada");
        System.out.println("3. Madera");
        System.out.println("4. Piedra Ender");
        System.out.println("5. Huevo");
    }

    public void printInventario(){
        for (Slot s: inventario
             ) {
            System.out.println(s.toString());
        }
    }





}
